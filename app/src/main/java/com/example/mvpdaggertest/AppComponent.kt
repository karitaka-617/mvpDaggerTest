package com.example.mvpdaggertest

import com.example.mvpdaggertest.main.MainActivityComponent
import com.example.mvpdaggertest.main.MainActivityModule
import dagger.Component

@Component
interface AppComponent {
    fun inject(app: CustomApplication)

    fun plus(module: MainActivityModule): MainActivityComponent
}