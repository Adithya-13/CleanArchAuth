package com.codext.project.core.data.source.remote.request.login


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String,
)