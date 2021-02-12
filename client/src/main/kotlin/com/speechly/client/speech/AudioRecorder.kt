package com.speechly.client.speech

import android.Manifest
import android.media.AudioRecord
import android.media.AudioFormat
import android.media.MediaRecorder
import android.content.pm.PackageManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

val REQUEST_AUDIO = 1

class AudioRecorder(var activity: android.app.Activity, val sampleRate: Int) {

    private var recording = false
    private var recorder: AudioRecord? = null

    private var permissionGranted: Boolean =
            activity.checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED

    private var bufferSize: Int? = null

    init {
        val channelMask = AudioFormat.CHANNEL_IN_MONO

        bufferSize = AudioRecord.getMinBufferSize(sampleRate, channelMask, AudioFormat.ENCODING_PCM_16BIT) * 4

        if (permissionGranted) {
            recorder = AudioRecord.Builder()
                    .setAudioSource(MediaRecorder.AudioSource.MIC)
                    .setAudioFormat(AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(this.sampleRate)
                            .setChannelMask(channelMask)
                            .build())
                    .setBufferSizeInBytes(bufferSize!!)
                    .build()
        } else {
            activity.requestPermissions(arrayOf<String>(Manifest.permission.RECORD_AUDIO), REQUEST_AUDIO)
        }
    }

    fun startRecording(): Flow<ByteArray> {
        recording = true
        recorder?.startRecording()

        val audioFlow = flow {
            var audioData: ByteArray = ByteArray(bufferSize!!)
            while(recording) {
                var bytesRead: Int? = recorder?.read(audioData, 0, audioData.size)
                if (bytesRead != null && bytesRead != 0) {
                    val data = audioData
                    emit(data)
                }
            }
        }
        return audioFlow.buffer()
    }

    fun stopRecording() {
        if (recording) {
            recording = false
            GlobalScope.launch(Dispatchers.IO) {
                delay(250)
                recorder?.stop()
            }
        }
    }

    fun close() {
    }
}