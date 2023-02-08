package com.example.testtask.data.remote.dto


data class NewsDtoItem(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourceDto,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)