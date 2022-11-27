package com.example.androidtask1.di

import com.example.androidtask1.data.remote.CatApi
import com.example.androidtask1.data.remote.responses.Cat
import com.example.androidtask1.repository.CatRepository
import com.example.androidtask1.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCatRepository(
        api:CatApi
    )=CatRepository(api)

    @Singleton
    @Provides
    fun provideCatApi():CatApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CatApi::class.java)
    }
}