package com.papaguycodes.screenrecorder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deep.videotrimmer.VideoTrimmer

class VideoEditingActivity : AppCompatActivity() {

    private lateinit var videoTrimmer: VideoTrimmer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_editing)

        videoTrimmer = findViewById(R.id.videoTrimmer)
        videoTrimmer.setVideoURI(intent.data)
        videoTrimmer.setOnTrimVideoListener(object : VideoTrimmer.OnTrimVideoListener {
            override fun onTrimStarted() {
                // Handle trim start
            }

            override fun getResult(uri: String) {
                // Handle trimmed video result
            }

            override fun cancelAction() {
                videoTrimmer.destroy()
                finish()
            }

            override fun onError(message: String) {
                // Handle error
            }
        })
    }
}
