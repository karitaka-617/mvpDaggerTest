package com.example.mvpdaggertest

import android.app.Application
import com.example.mvpdaggertest.data.GitRepository
import javax.inject.Inject

class CustomApplication: Application() {
    lateinit var appComponent: AppComponent
    @Inject lateinit var gitRepository: GitRepository

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .baseModule(BaseModule())
            .build()

        appComponent.inject(this)
    }
}