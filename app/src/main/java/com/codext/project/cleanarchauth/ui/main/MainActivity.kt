package com.codext.project.cleanarchauth.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codext.project.cleanarchauth.R
import com.codext.project.cleanarchauth.databinding.ActivityMainBinding
import com.codext.project.cleanarchauth.utils.AuthPreferences
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val authPreferences = AuthPreferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            token.text = authPreferences.getToken()
            userType.text = authPreferences.getUserType().toString()
        }
    }
}