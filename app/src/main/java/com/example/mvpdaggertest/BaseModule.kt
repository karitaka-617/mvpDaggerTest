package com.example.mvpdaggertest

import com.example.mvpdaggertest.data.GitRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule {

    @Singleton
    @Provides
    fun provideGitRepository(): GitRepository{
        return GitRepository.getInstance()
    }
}