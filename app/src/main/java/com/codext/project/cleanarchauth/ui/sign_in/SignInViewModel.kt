package com.codext.project.cleanarchauth.ui.sign_in

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.codext.project.core.data.source.remote.network.ApiResponse
import com.codext.project.core.data.source.remote.request.login.LoginRequest
import com.codext.project.core.data.source.remote.response.login.LoginResponse
import com.codext.project.core.domain.usecase.AuthUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel @ViewModelInject constructor(private val authUseCase: AuthUseCase) :
    ViewModel() {
    fun doLogin(loginRequest: LoginRequest): LiveData<ApiResponse<LoginResponse>> {
        Log.d("blabla", "dudu")
        val login = MutableLiveData<ApiResponse<LoginResponse>>()
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("blabla1", loginRequest.toString())
            val loginResponse = authUseCase.doLogin(loginRequest).asLiveData()
            Log.d("blabla2", loginResponse.value.toString())
            login.postValue(loginResponse.value)
        }
        return login
    }

}