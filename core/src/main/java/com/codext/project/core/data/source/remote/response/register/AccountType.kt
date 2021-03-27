package com.codext.project.core.data.source.remote.response.register


import com.google.gson.annotations.SerializedName

data class AccountType(
    @SerializedName("user_type")
    val userType: String,
    @SerializedName("user_type_identifier")
    val userTypeIdentifier: Int
)