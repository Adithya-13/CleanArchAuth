package com.codext.project.core.data.source.remote.response.register


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("account_type")
    val accountType: AccountType,
    @SerializedName("address")
    val address: Any,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("email")
    val email: Any,
    @SerializedName("fcm_token")
    val fcmToken: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("username")
    val username: String
)