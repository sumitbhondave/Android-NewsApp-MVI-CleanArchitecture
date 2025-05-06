package com.sumit.newsapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sumit.navigation.AppDestination
import com.sumit.newslist.ui.NewsListScreen

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.NewsList.route
    ) {
        composable(AppDestination.NewsList.route) {
            NewsListScreen()
        }
    }
}