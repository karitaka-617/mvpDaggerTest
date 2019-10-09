package com.example.mvpdaggertest.main

import com.example.mvpdaggertest.data.GitRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainActivityModule {

    @Singleton
    @Provides
    fun provideGitRepository(): GitRepository{
        return GitRepository
    }
}