package com.example.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val SPLASH_SCREEN_TIME: Long = 4000 // 4 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghilangkan status bar untuk fullscreen mode
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Menampilkan layout splash screen
        setContentView(R.layout.activity_splash)

        // Handler untuk delay splash screen selama SPLASH_SCREEN_TIME lalu pindah ke MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()
        }, SPLASH_SCREEN_TIME)
    }

    private fun goToMainActivity() {
        // Intent untuk membuka MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Menutup SplashActivity agar tidak bisa kembali dengan tombol back
    }
}
