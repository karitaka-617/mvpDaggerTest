package com.example.mvpdaggertest.main

import com.example.mvpdaggertest.BaseModule
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [BaseModule::class,MainActivityModule::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}