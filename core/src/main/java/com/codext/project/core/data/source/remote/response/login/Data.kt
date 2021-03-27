package com.codext.project.core.data.source.remote.response.login


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("token")
    val token: String,
    @SerializedName("user_type")
    val userType: Int
)