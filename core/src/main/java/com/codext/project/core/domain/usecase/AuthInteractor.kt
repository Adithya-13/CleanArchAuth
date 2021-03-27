package com.codext.project.core.domain.usecase

import com.codext.project.core.data.source.remote.network.ApiResponse
import com.codext.project.core.data.source.remote.request.login.LoginRequest
import com.codext.project.core.data.source.remote.request.register.RegisterRequest
import com.codext.project.core.data.source.remote.response.login.LoginResponse
import com.codext.project.core.data.source.remote.response.register.RegisterResponse
import com.codext.project.core.domain.repository.IAuthRepository
import com.codext.project.core.domain.usecase.AuthUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class AuthInteractor @Inject constructor(private val iAuthRepository: IAuthRepository) :
    AuthUseCase {
    override fun doLogin(loginRequest: LoginRequest): Flow<ApiResponse<LoginResponse>> =
        iAuthRepository.doLogin(loginRequest)

    override fun doRegister(registerRequest: RegisterRequest): Flow<ApiResponse<RegisterResponse>> =
        iAuthRepository.doRegister(registerRequest)
}