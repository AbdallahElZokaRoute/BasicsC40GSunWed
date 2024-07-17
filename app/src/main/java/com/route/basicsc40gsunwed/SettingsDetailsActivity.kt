package com.route.basicsc40gsunwed

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingsDetailsActivity : AppCompatActivity() {
    lateinit var titleTextView: TextView
    lateinit var iconImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_details)
        titleTextView = findViewById(R.id.settings_title)
        iconImageView = findViewById(R.id.settings_image)
        val title = intent.getStringExtra("title")
        val icon = intent.getIntExtra("icon", R.drawable.ic_launcher_foreground)
        titleTextView.text = title
        iconImageView.setImageResource(icon)
    }
}