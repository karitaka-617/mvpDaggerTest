package com.example.mvpdaggertest

import com.example.mvpdaggertest.detail.DetailActivityComponent
import com.example.mvpdaggertest.detail.DetailActivityModule
import com.example.mvpdaggertest.main.MainActivityComponent
import com.example.mvpdaggertest.main.MainActivityModule
import dagger.Component

@Component(modules = [BaseModule::class])
interface AppComponent {
    fun inject(app: CustomApplication)

    fun plus(module: MainActivityModule): MainActivityComponent

    fun plus(module: DetailActivityModule): DetailActivityComponent
}