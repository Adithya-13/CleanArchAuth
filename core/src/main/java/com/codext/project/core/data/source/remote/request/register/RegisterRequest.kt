package com.codext.project.core.data.source.remote.request.register


import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("user_type")
    val userType: Int,
    @SerializedName("username")
    val username: String
)