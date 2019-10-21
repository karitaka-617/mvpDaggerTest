package com.example.mvpdaggertest.detail

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class DetailActivityModule {

    @Provides
    fun provideDetailFragment(): DetailFragment{
        return DetailFragment.newInstance()
    }
}