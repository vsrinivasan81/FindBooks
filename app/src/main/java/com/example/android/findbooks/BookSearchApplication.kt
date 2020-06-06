package com.example.android.findbooks

import android.app.Application
import timber.log.Timber

class BookSearchApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}