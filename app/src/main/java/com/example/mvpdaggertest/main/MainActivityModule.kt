package com.example.mvpdaggertest.main

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainFragment(): MainFragment {
        Log.d("dagger2","testMain")
        return MainFragment.newInstance()
    }
}