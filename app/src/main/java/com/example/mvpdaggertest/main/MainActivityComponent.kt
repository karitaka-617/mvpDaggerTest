package com.example.mvpdaggertest.main

import com.example.mvpdaggertest.ActivityScope
import com.example.mvpdaggertest.BaseModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [BaseModule::class,MainActivityModule::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}