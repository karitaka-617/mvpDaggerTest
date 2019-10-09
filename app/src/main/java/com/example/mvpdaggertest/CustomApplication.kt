package com.example.mvpdaggertest

import android.app.Application
import com.example.mvpdaggertest.main.DaggerMainActivityComponent
import com.example.mvpdaggertest.main.MainActivityComponent
import com.example.mvpdaggertest.main.MainActivityModule

class CustomApplication: Application() {
    lateinit var appComponent: MainActivityComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerMainActivityComponent
            .builder()
            .mainActivityModule(MainActivityModule())
            .build()
    }
}