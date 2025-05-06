package com.sumit.newslist.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sumit.domain.entity.News

@Composable
fun NewsList(news: List<News>, modifier: Modifier) {
    LazyColumn(modifier = modifier.fillMaxHeight()) {
        items(news, key = { it.title }) { news ->
            with(news) {
                NewsItem(
                    title = title,
                    description = description,
                    urlToImage = urlToImage
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NewsListPreview() {
    NewsList(
        news = listOf(
            News(
                title = "Brazilian police arrest 2 suspects over alleged plot targeting Lady Gaga's concert in Rio - ABC News",
                author = "ABC News",
                description = "Brazilian police arrest 2 suspects over alleged plot targeting Lady Gaga's concert in Rio - ABC News",
                urlToImage = "https://abcnews.go.com/International/brazilian-police-arrest-2-suspects-bomb-plot-targeting/story?id\\\\u003d121448479",
            ),
            News(
                title = "Stephen Curry and Buddy Hield lead Warriors past Rockets 103-89 in Game 7 - AP News",
                author = "Kristie Rieken",
                description = "Stephen Curry scored 14 of his 22 points in the fourth quarter, Buddy Hield made nine 3-pointers and scored 33 points.",
                urlToImage = "https://images.axios.com/dotvl7_8NvfR5pmIQzDBocNrnWU=/0x118:3000x1806/1366x768/2025/05/04/1746387666335.jpg",
            )
        ),
        modifier = Modifier.padding(16.dp)
    )
}
