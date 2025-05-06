package com.sumit.newslist.intent

sealed class NewsListIntent {

    data object FetchNews : NewsListIntent()
}