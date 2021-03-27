package com.codext.project.cleanarchauth.ui.sign_in

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.codext.project.cleanarchauth.databinding.ActivitySignInBinding
import com.codext.project.cleanarchauth.ui.main.MainActivity
import com.codext.project.cleanarchauth.utils.AuthPreferences
import com.codext.project.core.data.source.remote.network.ApiResponse
import com.codext.project.core.data.source.remote.request.login.LoginRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private val signInViewModel: SignInViewModel by viewModels()
    private val authPreferences = AuthPreferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            btnSignUp.setOnClickListener {
                startActivity(Intent(this@SignInActivity, SignInActivity::class.java))
            }

            val inputPhone = inputPhone.text.toString()
            val inputPassword = inputPassword.text.toString()

            btnSignIn.setOnClickListener {
                signInViewModel.doLogin(LoginRequest(inputPassword, inputPhone))
                    .observe(this@SignInActivity, {
                        when (it) {
                            is ApiResponse.Success -> {
                                authPreferences.saveUserType(it.data.data.userType)
                                authPreferences.saveToken(it.data.data.token)
                                startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                            }
                            is ApiResponse.Empty -> {
                            }
                            is ApiResponse.Error -> {
                                Toast.makeText(
                                    this@SignInActivity,
                                    "Failed to Signup",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    })
            }
        }
    }
}