package com.example.testtask.domain.model


data class News(
    val status:String = "",
    val totalResults: Int = 0,
    val articles: List<NewsItem> = ArrayList<NewsItem>(),
)