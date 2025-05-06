package com.sumit.newslist.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun NewsItem(title: String, description: String, urlToImage: String) {
    Card(
        Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        ListItem(
            headlineContent = { Text(title, maxLines = 1) },
            leadingContent = {
                AsyncImage(
                    model =
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(urlToImage)
                        .error(android.R.drawable.ic_menu_report_image)
                        .placeholder(android.R.drawable.ic_menu_report_image)
                        .build(),
                    contentDescription = title,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth(0.33f),
                )
            },
            supportingContent = {
                Text(
                    text = description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )
            },
        )
    }
}