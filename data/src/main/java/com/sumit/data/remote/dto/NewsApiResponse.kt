package com.sumit.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class NewsApiResponse(val articles: List<Articles>)

@Serializable
data class Articles(
    val source: Source? = null,
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val content: String? = null
)

@Serializable
data class Source(val id: String?, val name: String?)
