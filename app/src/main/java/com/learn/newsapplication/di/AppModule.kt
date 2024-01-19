package com.learn.newsapplication.di

import android.app.Application
import com.learn.newsapplication.data.local.LocalUserStoreImpl
import com.learn.newsapplication.data.remote.NewsApiInterface
import com.learn.newsapplication.data.repository.NewsRepositoryImpl
import com.learn.newsapplication.domain.local.LocalUserStore
import com.learn.newsapplication.domain.repository.NewsRepository
import com.learn.newsapplication.domain.usecases.appEntry.AppEntryUseCases
import com.learn.newsapplication.domain.usecases.appEntry.ReadUserAppEntry
import com.learn.newsapplication.domain.usecases.appEntry.SaveUserAppEntry
import com.learn.newsapplication.domain.usecases.news.GetNews
import com.learn.newsapplication.domain.usecases.news.NewsUseCases
import com.learn.newsapplication.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    ): AppEntryUseCases = AppEntryUseCases(
        readUserAppEntry = ReadUserAppEntry(localUserStore),
        saveUserAppEntry = SaveUserAppEntry(localUserStore)
    )

    //providing the instance of retrofit
    @Provides
    @Singleton
    fun provideNewsApiInterface():NewsApiInterface{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApiInterface:NewsApiInterface
    ):NewsRepository = NewsRepositoryImpl(newsApiInterface)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ):NewsUseCases{
        return NewsUseCases(getNews = GetNews(newsRepository))
    }

}