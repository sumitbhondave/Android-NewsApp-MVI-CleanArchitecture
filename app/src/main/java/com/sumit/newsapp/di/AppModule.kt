package com.sumit.newsapp.di

import com.sumit.common.CoroutineDispatcherProvider
import com.sumit.data.remote.NewsApiService
import com.sumit.data.repository.NewsRepositoryImpl
import com.sumit.domain.repository.NewsRepository
import com.sumit.domain.usecase.GetTopHeadlinesUseCase
import com.sumit.newsapp.BuildConfig
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
    fun provideNewsRepository(newsApiService: NewsApiService): NewsRepository {
        return NewsRepositoryImpl(
            apiKey = BuildConfig.API_KEY,
            newsApiService = newsApiService,
            dispatcherProvider = CoroutineDispatcherProvider() // need to check here
        )
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: NewsRepository): GetTopHeadlinesUseCase {
        return GetTopHeadlinesUseCase(repository)
    }
}