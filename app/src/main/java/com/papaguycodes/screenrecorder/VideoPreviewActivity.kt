package com.papaguycodes.screenrecorder

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.ImageButton
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class VideoPreviewActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private lateinit var playButton: ImageButton
    private lateinit var pauseButton: ImageButton
    private lateinit var deleteButton: Button
    private lateinit var videoTitleTextView: TextView
    private lateinit var videoUri: Uri
    private lateinit var videoFile: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_preview)

        // Initialize UI components
        videoView = findViewById(R.id.videoView)
        playButton = findViewById(R.id.playButton)
        pauseButton = findViewById(R.id.pauseButton)
        deleteButton = findViewById(R.id.deleteButton)
        videoTitleTextView = findViewById(R.id.videoTitleTextView)

        // Get video URI from intent
        val intent = intent
        videoUri = intent.getParcelableExtra("VIDEO_URI") ?: return
        videoFile = File(videoUri.path ?: return)
        
        // Set video URI to the VideoView
        videoView.setVideoURI(videoUri)
        videoView.setMediaController(MediaController(this))
        videoView.requestFocus()

        // Set video title
        videoTitleTextView.text = videoFile.name

        // Play button functionality
        playButton.setOnClickListener {
            videoView.start()
        }

        // Pause button functionality
        pauseButton.setOnClickListener {
            videoView.pause()
        }

        // Delete button functionality
        deleteButton.setOnClickListener {
            deleteVideo()
        }
    }

    private fun deleteVideo() {
        if (videoFile.exists()) {
            val deleted = videoFile.delete()
            if (deleted) {
                // Notify user of success and return to previous screen
                showToast("Video deleted successfully")
                finish()
            } else {
                // Notify user of failure
                showToast("Failed to delete video")
            }
        } else {
            showToast("Video file not found")
        }
    }

    private fun showToast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }
}
