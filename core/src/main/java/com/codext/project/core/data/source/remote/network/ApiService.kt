package com.codext.project.core.data.source.remote.network

import com.codext.project.core.data.source.remote.request.login.LoginRequest
import com.codext.project.core.data.source.remote.request.register.RegisterRequest
import com.codext.project.core.data.source.remote.response.login.LoginResponse
import com.codext.project.core.data.source.remote.response.register.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun doLogin(
        @Body loginRequest: LoginRequest
    ): LoginResponse

    @POST("register")
    suspend fun doRegister(
        @Body registerRequest: RegisterRequest
    ): RegisterResponse

}