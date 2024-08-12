package com.papaguycodes.screenrecorder

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var themeSpinner: Spinner
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        themeSpinner = findViewById(R.id.themeSpinner)
        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE)

        // Setup spinner to select theme
        themeSpinner.setOnItemSelectedListener { parent, _, position, _ ->
            val selectedTheme = parent.getItemAtPosition(position).toString()
            setTheme(selectedTheme)
        }
    }

    private fun setTheme(theme: String) {
        val editor = sharedPreferences.edit()
        when (theme) {
            "Default" -> editor.putInt("theme", R.style.Theme_ScreenRecorder)
            "Dark" -> editor.putInt("theme", R.style.Theme_ScreenRecorder_Dark)
            "GitHub Dark" -> editor.putInt("theme", R.style.Theme_ScreenRecorder_GitHubDark)
        }
        editor.apply()

        recreate() // Restart the activity to apply the new theme
    }
}
