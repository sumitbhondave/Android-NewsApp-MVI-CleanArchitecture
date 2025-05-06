package com.sumit.domain.usecase

import com.sumit.domain.repository.NewsRepository

class GetTopHeadlinesUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke() = repository.getNews()
}
