package com.sumit.data.remote

import com.sumit.data.remote.dto.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String
    ): Response<NewsApiResponse>
}