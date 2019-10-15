package com.example.mvpdaggertest.main

import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}