package com.example.test.model

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)