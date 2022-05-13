package com.example.newscompose.data

data class NewsEntity(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceEntity,
    val title: String,
    val url: String,
    val urlToImage: String
)
data class NewsResponse(val status:String, val totalResults:Int,val articles:List<NewsEntity>)
data class SourceEntity(
    val id: Any,
    val name: String
)