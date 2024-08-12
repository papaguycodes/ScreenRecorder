package com.papaguycodes.screenrecorder

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 2000) // Splash screen delay time
    }
}
