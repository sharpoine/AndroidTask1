package com.example.androidtask1.repository

import com.example.androidtask1.data.remote.CatApi
import com.example.androidtask1.data.remote.responses.Cat
import com.example.androidtask1.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CatRepository @Inject constructor(
    private val catApi: CatApi
) {
    suspend fun getCat():Resource<Cat>{
        val response=try {
            catApi.getCat()
        }catch (e:Exception){
            return Resource.Error("Bilinmeyen Hata")
        }
        return Resource.Success(response)
    }
}