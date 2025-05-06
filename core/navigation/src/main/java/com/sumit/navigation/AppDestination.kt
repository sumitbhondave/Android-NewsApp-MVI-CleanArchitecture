package com.sumit.navigation

sealed class AppDestination(val route: String) {
    data object NewsList : AppDestination("newsList")
    data object NewsDetails : AppDestination("newsDetail/{itemId}") {
        fun createRoute(itemId: String) = "newsDetail/$itemId"
    }
}
