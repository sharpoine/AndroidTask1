package com.example.androidtask1.data.remote.responses


import com.google.gson.annotations.SerializedName

data class CatItem(
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)