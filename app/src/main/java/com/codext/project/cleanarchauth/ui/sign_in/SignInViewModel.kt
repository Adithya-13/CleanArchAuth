package com.codext.project.cleanarchauth.ui.sign_in

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.codext.project.core.data.source.remote.network.ApiResponse
import com.codext.project.core.data.source.remote.request.login.LoginRequest
import com.codext.project.core.data.source.remote.response.login.LoginResponse
import com.codext.project.core.domain.usecase.AuthUseCase

class SignInViewModel @ViewModelInject constructor(private val authUseCase: AuthUseCase) :
    ViewModel() {
    fun doLogin(loginRequest: LoginRequest): LiveData<ApiResponse<LoginResponse>> {
        return authUseCase.doLogin(loginRequest).asLiveData()
    }
}