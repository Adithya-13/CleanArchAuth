package com.codext.project.cleanarchauth.ui.sign_up

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.codext.project.core.data.source.remote.network.ApiResponse
import com.codext.project.core.data.source.remote.request.register.RegisterRequest
import com.codext.project.core.data.source.remote.response.register.RegisterResponse
import com.codext.project.core.domain.usecase.AuthUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel @ViewModelInject constructor(private val authUseCase: AuthUseCase) :
    ViewModel() {
    fun doRegister(registerRequest: RegisterRequest): LiveData<ApiResponse<RegisterResponse>> {
        val register = MutableLiveData<ApiResponse<RegisterResponse>>()
        viewModelScope.launch(Dispatchers.IO) {
            val registerResponse = authUseCase.doRegister(registerRequest).asLiveData()
            register.postValue(registerResponse.value)
        }
        return register
    }

}