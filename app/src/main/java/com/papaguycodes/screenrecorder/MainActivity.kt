package com.papaguycodes.screenrecorder

import android.content.Intent
import android.media.projection.MediaProjectionManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var startRecordingButton: Button
    private lateinit var stopRecordingButton: Button
    private lateinit var openSettingsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startRecordingButton = findViewById(R.id.startRecordingButton)
        stopRecordingButton = findViewById(R.id.stopRecordingButton)
        openSettingsButton = findViewById(R.id.openSettingsButton)

        val mediaProjectionManager = getSystemService(MEDIA_PROJECTION_SERVICE) as MediaProjectionManager

        startRecordingButton.setOnClickListener {
            val intent = mediaProjectionManager.createScreenCaptureIntent()
            startActivityForResult(intent, REQUEST_CODE)
        }

        stopRecordingButton.setOnClickListener {
            val stopIntent = Intent(this, ScreenRecordService::class.java)
            stopIntent.action = ScreenRecordService.ACTION_STOP
            startService(stopIntent)
        }

        openSettingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private const val REQUEST_CODE = 1000
    }
}
