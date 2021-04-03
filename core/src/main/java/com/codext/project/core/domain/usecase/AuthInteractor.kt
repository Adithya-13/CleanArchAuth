package com.codext.project.core.domain.usecase

import android.util.Log
import com.codext.project.core.data.source.remote.network.ApiResponse
import com.codext.project.core.data.source.remote.request.login.LoginRequest
import com.codext.project.core.data.source.remote.request.register.RegisterRequest
import com.codext.project.core.data.source.remote.response.login.LoginResponse
import com.codext.project.core.data.source.remote.response.register.RegisterResponse
import com.codext.project.core.domain.repository.IAuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val iAuthRepository: IAuthRepository) :
    AuthUseCase {
    override suspend fun doLogin(loginRequest: LoginRequest): Flow<ApiResponse<LoginResponse>> {
        Log.d("blabla3", loginRequest.toString())
        return iAuthRepository.doLogin(loginRequest)
    }

    override suspend fun doRegister(registerRequest: RegisterRequest): Flow<ApiResponse<RegisterResponse>> =
        iAuthRepository.doRegister(registerRequest)
}