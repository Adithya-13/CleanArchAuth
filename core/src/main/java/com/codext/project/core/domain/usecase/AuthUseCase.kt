package com.codext.project.core.domain.usecase

import com.codext.project.core.data.source.remote.network.ApiResponse
import com.codext.project.core.data.source.remote.request.login.LoginRequest
import com.codext.project.core.data.source.remote.request.register.RegisterRequest
import com.codext.project.core.data.source.remote.response.login.LoginResponse
import com.codext.project.core.data.source.remote.response.register.RegisterResponse
import kotlinx.coroutines.flow.Flow

interface AuthUseCase {
    fun doLogin(loginRequest: LoginRequest): Flow<ApiResponse<LoginResponse>>
    fun doRegister(registerRequest: RegisterRequest): Flow<ApiResponse<RegisterResponse>>
}