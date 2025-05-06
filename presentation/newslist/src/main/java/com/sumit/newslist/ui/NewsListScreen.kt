package com.sumit.newslist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sumit.newslist.R
import com.sumit.newslist.intent.NewsListIntent
import com.sumit.newslist.viewmodel.NewsListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListScreen(
    viewModel: NewsListViewModel = hiltViewModel()
) {
    val viewState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onIntent(NewsListIntent.FetchNews)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(16.dp),
                title = { Text(stringResource(R.string.top_headlines)) }
            )
        }
    ) { innerPadding ->
        when {
            viewState.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            viewState.isError -> {
                ErrorScreen(
                    errorMessage = viewState.errorMessage.orEmpty(),
                    buttonText = stringResource(R.string.try_again),
                    retryAction = { intent ->
                        viewModel.onIntent(intent)
                    }
                )
            }

            viewState.isSuccess -> {
                viewState.data?.let {
                    NewsList(
                        news = it,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}