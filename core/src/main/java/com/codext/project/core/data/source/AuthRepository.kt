package com.codext.project.core.data.source

import com.codext.project.core.data.source.remote.RemoteDataSource
import com.codext.project.core.data.source.remote.network.ApiResponse
import com.codext.project.core.data.source.remote.request.login.LoginRequest
import com.codext.project.core.data.source.remote.request.register.RegisterRequest
import com.codext.project.core.data.source.remote.response.login.LoginResponse
import com.codext.project.core.data.source.remote.response.register.RegisterResponse
import com.codext.project.core.domain.repository.IAuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : IAuthRepository {
    override fun doLogin(loginRequest: LoginRequest): Flow<ApiResponse<LoginResponse>> {
        return remoteDataSource.doLogin(loginRequest)
    }

    override fun doRegister(registerRequest: RegisterRequest): Flow<ApiResponse<RegisterResponse>> {
        return remoteDataSource.doRegister(registerRequest)
    }
}