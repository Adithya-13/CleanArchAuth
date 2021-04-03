package com.codext.project.core.data.source.remote

import android.util.Log
import com.codext.project.core.data.source.remote.network.ApiResponse
import com.codext.project.core.data.source.remote.network.ApiService
import com.codext.project.core.data.source.remote.request.login.LoginRequest
import com.codext.project.core.data.source.remote.request.register.RegisterRequest
import com.codext.project.core.data.source.remote.response.login.LoginResponse
import com.codext.project.core.data.source.remote.response.register.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun doLogin(loginRequest: LoginRequest): Flow<ApiResponse<LoginResponse>> {
        return flow {
            try {
                val response = apiService.doLogin(loginRequest)
                Log.d("blabla6", response.toString())
                if (response.success) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                Log.d("blabla6", e.toString())
                emit(ApiResponse.Error(e.toString()))
                Log.e(RemoteDataSource::class.simpleName, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun doRegister(registerRequest: RegisterRequest): Flow<ApiResponse<RegisterResponse>> {
        return flow {
            try {
                val response = apiService.doRegister(registerRequest)
                Log.d("blabla1", response.toString())
                if (response.success) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(RemoteDataSource::class.simpleName, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}