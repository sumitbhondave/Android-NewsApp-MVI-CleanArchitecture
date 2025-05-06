package com.sumit.domain.repository

import com.sumit.domain.entity.News

interface NewsRepository {
    suspend fun getNews(): Result<List<News>>
}