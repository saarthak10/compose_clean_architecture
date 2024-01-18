package com.learn.newsapplication.di

import android.app.Application
import com.learn.newsapplication.data.local.LocalUserStoreImpl
import com.learn.newsapplication.domain.local.LocalUserStore
import com.learn.newsapplication.domain.usecases.AppEntryUseCases
import com.learn.newsapplication.domain.usecases.ReadUserAppEntry
import com.learn.newsapplication.domain.usecases.SaveUserAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserStore(
        application: Application
    ):LocalUserStore = LocalUserStoreImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserStore: LocalUserStore
    ): AppEntryUseCases=AppEntryUseCases(
        readUserAppEntry = ReadUserAppEntry(localUserStore),
        saveUserAppEntry = SaveUserAppEntry(localUserStore)
    )
}