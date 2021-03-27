package com.codext.project.cleanarchauth.ui.sign_up

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.codext.project.cleanarchauth.databinding.ActivitySignUpBinding
import com.codext.project.cleanarchauth.ui.sign_in.SignInActivity
import com.codext.project.cleanarchauth.utils.AuthPreferences
import com.codext.project.core.data.source.remote.network.ApiResponse
import com.codext.project.core.data.source.remote.request.register.RegisterRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val signUpViewModel: SignUpViewModel by viewModels()
    private val authPreferences = AuthPreferences(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            progressCircular.visibility = View.GONE

            val inputPhone = inputPhone.text.toString()
            val inputPassword = inputPassword.text.toString()
            val inputName = inputName.text.toString()
            val inputEmail = inputEmail.text.toString()
            val inputPlate = inputPlate.text.toString()
            val inputVehicles = inputLayoutVehicles.editText?.text.toString()

            btnSignUp.setOnClickListener {
                val registerRequest =
                    RegisterRequest(
                        inputName,
                        inputPassword,
                        inputPhone,
                        inputPlate.toInt(),
                        "blabla"
                    )
                signUpViewModel.doRegister(registerRequest).observe(this@SignUpActivity, {
                    when (it) {
                        is ApiResponse.Success -> {
                            progressCircular.visibility = View.GONE
                            startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                        }
                        is ApiResponse.Empty -> {
                            progressCircular.visibility = View.VISIBLE
                        }
                        is ApiResponse.Error -> {
                            progressCircular.visibility = View.GONE
                            Toast.makeText(
                                this@SignUpActivity,
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