package com.speechly.client.speech

import android.Manifest
import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class AudioRecorder(var activity: AppCompatActivity, val sampleRate: Int) {

    private var recording = false
    private var recorder: AudioRecord? = null
    private val channelMask = AudioFormat.CHANNEL_IN_MONO
    private val bufferSize = AudioRecord.getMinBufferSize(sampleRate, channelMask, AudioFormat.ENCODING_PCM_16BIT) * 4

    private val requestPermissionLauncher = activity.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                buildRecorder()
            } else {
                throw Exception("Need access to microphone")
            }
        }

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
            requestPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
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