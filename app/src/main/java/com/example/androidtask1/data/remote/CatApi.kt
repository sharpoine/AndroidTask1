package com.example.androidtask1.data.remote

import com.example.androidtask1.data.remote.responses.Cat
import retrofit2.http.GET


interface CatApi {
    @GET("search")
    suspend fun getCat():Cat
}