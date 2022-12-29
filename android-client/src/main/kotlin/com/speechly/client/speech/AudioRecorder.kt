package com.speechly.client.speech

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class AudioRecorder(var activity: Activity, val sampleRate: Int) {

    val RECORD_AUDIO_REQUEST_CODE = 15001
    private var recording = false
    private var recorder: AudioRecord? = null
    private val channelMask = AudioFormat.CHANNEL_IN_MONO
    private val bufferSize = AudioRecord.getMinBufferSize(sampleRate, channelMask, AudioFormat.ENCODING_PCM_16BIT) * 4

    fun buildRecorder() {
        if (activity.checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
            recorder = AudioRecord.Builder()
                    .setAudioSource(MediaRecorder.AudioSource.MIC)
                    .setAudioFormat(AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(this.sampleRate)
                            .setChannelMask(channelMask)
                            .build())
                    .setBufferSizeInBytes(bufferSize)
                    .build()
        } else {
            requestPermissions(activity,
                arrayOf(Manifest.permission.RECORD_AUDIO),
                RECORD_AUDIO_REQUEST_CODE)
            ActivityCompat.OnRequestPermissionsResultCallback { code, permissions, results ->
                if (code == RECORD_AUDIO_REQUEST_CODE
                    && results[0] == PackageManager.PERMISSION_GRANTED ) {
                    buildRecorder()
                }
            }
        }
    }

    fun startRecording(): Flow<ByteArray> {
        recording = true
        recorder?.startRecording()

        val audioFlow = flow {
            val audioData: ByteArray = ByteArray(bufferSize)
            while(recording) {
                val bytesRead: Int? = recorder?.read(audioData, 0, audioData.size)
                if (bytesRead != null && bytesRead != 0) {
                    emit(audioData)
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