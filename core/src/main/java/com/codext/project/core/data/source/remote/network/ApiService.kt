package com.codext.project.core.data.source.remote.network

import com.codext.project.core.data.source.remote.request.login.LoginRequest
import com.codext.project.core.data.source.remote.request.register.RegisterRequest
import com.codext.project.core.data.source.remote.response.login.LoginResponse
import com.codext.project.core.data.source.remote.response.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("api/v1/login")
    suspend fun doLogin(
        @Body loginRequest: LoginRequest
    ): LoginResponse

    @POST("api/v1/register")
    suspend fun doRegister(
        @Body registerRequest: RegisterRequest
    ): RegisterResponse

}