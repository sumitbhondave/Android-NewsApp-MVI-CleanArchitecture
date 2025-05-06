package com.sumit.newslist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sumit.newslist.intent.NewsListIntent

@Composable
fun ErrorScreen(
    errorMessage: String,
    buttonText: String,
    retryAction: (NewsListIntent) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = errorMessage)
        Button(
            onClick = { retryAction(NewsListIntent.FetchNews) },
            modifier = Modifier.padding(24.dp),
        ) {
            Text(text = buttonText)
        }
    }
}