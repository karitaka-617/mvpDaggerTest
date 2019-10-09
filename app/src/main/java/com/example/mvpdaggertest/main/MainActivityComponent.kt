package com.example.mvpdaggertest.main

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}