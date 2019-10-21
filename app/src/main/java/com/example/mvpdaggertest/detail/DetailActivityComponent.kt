package com.example.mvpdaggertest.detail

import com.example.mvpdaggertest.ActivityScope
import com.example.mvpdaggertest.BaseModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [BaseModule::class,DetailActivityModule::class])
interface DetailActivityComponent {
    fun inject(activity: DetailActivity)
}