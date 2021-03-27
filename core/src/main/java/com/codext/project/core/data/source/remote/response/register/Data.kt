package com.codext.project.core.data.source.remote.response.register


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("data")
    val `data`: DataX
)