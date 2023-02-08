package com.example.testtask.data.mappers

import com.example.testtask.domain.model.News
import com.example.testtask.domain.model.NewsItem
import com.example.testtask.data.remote.dto.NewsDto
import com.example.testtask.data.remote.dto.NewsDtoItem

fun NewsDto.toNews(): News {
    return News(
        status = status?: "",
        totalResults = totalResults ?: 0,
        articles = articles.map { it.toNewsItem() },
    )
}

fun NewsDtoItem.toNewsItem(): NewsItem {
    return NewsItem(
        author = author?: "",
        content = content?: "",
        description = description?: "",
        publishedAt = publishedAt?: "",
        title = title?: "",
        url = url?: "",
        urlToImage = urlToImage?: ""
    )
}