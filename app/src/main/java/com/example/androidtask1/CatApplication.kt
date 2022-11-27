package com.example.androidtask1

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree

@HiltAndroidApp
class CatApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
    }
}