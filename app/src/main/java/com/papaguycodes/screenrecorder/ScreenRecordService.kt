<!-- //💡In the Beginning, PaPaGuy wrote beautiful Codes < /> 💜❤️ // -->
package com.papaguycodes.screenrecorder

import android.app.Service
import android.content.Intent
import android.media.MediaRecorder
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.os.IBinder
import android.util.Display```kotlin
import android.util.DisplayMetrics
import android.view.WindowManager
import java.io.File

class ScreenRecordService : Service() {

    private lateinit var mediaProjection: MediaProjection
    private lateinit var mediaProjectionManager: MediaProjectionManager
    private lateinit var mediaRecorder: MediaRecorder
    private var isRecording = false

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_START -> startRecording(intent)
            ACTION_STOP -> stopRecording()
        }
        return START_NOT_STICKY
    }

    private fun startRecording(intent: Intent) {
        if (isRecording) return

        val windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)

        mediaProjectionManager = getSystemService(MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
        mediaProjection = mediaProjectionManager.getMediaProjection(RESULT_OK, intent)

        mediaRecorder = MediaRecorder().apply {
            setVideoSource(MediaRecorder.VideoSource.SURFACE)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setVideoEncoder(MediaRecorder.VideoEncoder.H264)
            setVideoSize(metrics.widthPixels, metrics.heightPixels)
            setVideoFrameRate(30)
            setVideoEncodingBitRate(5 * 1024 * 1024)
            setOutputFile(File(getExternalFilesDir(null), "recording.mp4").absolutePath)
            prepare()
        }

        val surface = mediaRecorder.surface
        mediaProjection.createVirtualDisplay(
            "ScreenRecordService",
            metrics.widthPixels,
            metrics.heightPixels,
            metrics.densityDpi,
            0,
            surface,
            null,
            null
        )

        mediaRecorder.start()
        isRecording = true
    }

    private fun stopRecording() {
        if (!isRecording) return

        mediaRecorder.stop()
        mediaRecorder.reset()
        mediaProjection.stop()

        isRecording = false
        stopSelf()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    companion object {
        const val ACTION_START = "START_RECORDING"
        const val ACTION_STOP = "STOP_RECORDING"
        const val RESULT_OK = -1
    }
}
