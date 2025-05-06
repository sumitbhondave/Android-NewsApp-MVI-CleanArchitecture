package com.sumit.newslist.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumit.domain.usecase.GetTopHeadlinesUseCase
import com.sumit.newslist.intent.NewsListIntent
import com.sumit.newslist.state.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val topHeadlinesUseCase: GetTopHeadlinesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(NewsState())
    val uiState: StateFlow<NewsState> = _uiState.asStateFlow()

    fun onIntent(intent: NewsListIntent) {
        when (intent) {
            NewsListIntent.FetchNews -> {
                fetchNews()
            }
        }
    }

    private fun fetchNews() {
        viewModelScope.launch {
            _uiState.tryEmit(NewsState(isLoading = true))
            topHeadlinesUseCase().fold(
                onSuccess = {
                    _uiState.tryEmit(NewsState(isSuccess = true, data = it))
                },
                onFailure = { e ->
                    Log.e(LOG_TAG, "onFailure of fetchNews :: $e ")
                    _uiState.tryEmit(NewsState(isError = true, errorMessage = e.message))
                }
            )
        }
    }

    private companion object {
        const val LOG_TAG = "NewsListViewModel"
    }
}