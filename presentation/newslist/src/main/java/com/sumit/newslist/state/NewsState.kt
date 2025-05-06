package com.sumit.newslist.state

import com.sumit.domain.entity.News

data class NewsState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val data: List<News>? = null,
    val isError: Boolean = false,
    val errorMessage: String? = null,
)