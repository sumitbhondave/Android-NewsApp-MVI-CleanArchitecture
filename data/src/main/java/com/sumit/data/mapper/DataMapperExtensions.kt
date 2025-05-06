package com.sumit.data.mapper

import com.sumit.data.remote.dto.Articles
import com.sumit.domain.entity.News

internal fun Articles.toDomain() = News(
    title = title ?: "",
    author = author ?: "",
    description = description ?: "",
    urlToImage = urlToImage ?: "",
)