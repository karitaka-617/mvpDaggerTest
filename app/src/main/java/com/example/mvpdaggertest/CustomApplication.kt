package com.example.mvpdaggertest

import android.app.Application

class CustomApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .build()

        appComponent.inject(this)
    }
}