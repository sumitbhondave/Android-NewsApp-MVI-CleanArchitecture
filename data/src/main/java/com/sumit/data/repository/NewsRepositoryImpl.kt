package com.sumit.data.repository

import com.sumit.common.CoroutineDispatcherProvider
import com.sumit.data.mapper.toDomain
import com.sumit.data.remote.NewsApiService
import com.sumit.domain.repository.NewsRepository
import com.sumit.network.utils.apiCallToResult
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiKey: String,
    private val newsApiService: NewsApiService,
    private val dispatcherProvider: CoroutineDispatcherProvider
) : NewsRepository {
    override suspend fun getNews() =
        apiCallToResult(
            apiCall = { newsApiService.getTopHeadLines(apiKey = apiKey) },
            transform = { newsResponse ->
                Result.success(newsResponse.articles.map { it.toDomain() })
            },
            coroutineDispatcher = dispatcherProvider
        )
}