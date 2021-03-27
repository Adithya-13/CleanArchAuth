package com.codext.project.cleanarchauth.ui.sign_up

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.codext.project.core.data.source.remote.network.ApiResponse
import com.codext.project.core.data.source.remote.request.register.RegisterRequest
import com.codext.project.core.data.source.remote.response.register.RegisterResponse
import com.codext.project.core.domain.usecase.AuthUseCase

class SignUpViewModel @ViewModelInject constructor(private val authUseCase: AuthUseCase) :
    ViewModel() {
    fun doRegister(registerRequest: RegisterRequest): LiveData<ApiResponse<RegisterResponse>> {
        return authUseCase.doRegister(registerRequest).asLiveData()
    }
}