package com.codext.project.cleanarchauth.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.codext.project.cleanarchauth.databinding.ActivitySplashBinding
import com.codext.project.cleanarchauth.ui.main.MainActivity
import com.codext.project.cleanarchauth.ui.sign_in.SignInActivity
import com.codext.project.cleanarchauth.utils.AuthPreferences
import dagger.hilt.android.AndroidEntryPoint

class SplashActivity : AppCompatActivity() {

    private val splashScreenTime: Long = 2000
    private lateinit var binding: ActivitySplashBinding
    private val authPreferences = AuthPreferences(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (authPreferences.getToken().isNullOrBlank()) {
            Handler(mainLooper).postDelayed({
                startActivity(Intent(this, SignInActivity::class.java))
                finish()
            }, splashScreenTime)
        } else {
            Handler(mainLooper).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, splashScreenTime)
        }
    }
}