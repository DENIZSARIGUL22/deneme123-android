package com.example.deneme123.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.deneme123.R
import com.example.deneme123.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    // Ne kadar süre splash gösterilsin (ms cinsinden)
    private val SPLASH_DURATION = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Splash layout’unu yükle
        setContentView(R.layout.activity_splash)

        // Belirtilen süre kadar bekle, sonra LoginActivity’ye geç
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish() // Splash’i back stack’ten sil
        }, SPLASH_DURATION)
    }
}
