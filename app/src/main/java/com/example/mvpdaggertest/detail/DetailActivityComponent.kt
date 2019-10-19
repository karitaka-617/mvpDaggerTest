package com.example.mvpdaggertest.detail

import com.example.mvpdaggertest.BaseModule
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = [BaseModule::class,DetailActivityModule::class])
interface DetailActivityComponent {
    fun inject(activity: DetailActivity)
}