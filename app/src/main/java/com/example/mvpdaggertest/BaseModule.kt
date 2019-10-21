package com.example.mvpdaggertest

import android.util.Log
import com.example.mvpdaggertest.data.GitRepository
import dagger.Module
import dagger.Provides

@Module
class BaseModule {

    @Provides
    fun provideGitRepository(): GitRepository{
        Log.d("dagger2","test")
        return GitRepository.getInstance()
    }
}