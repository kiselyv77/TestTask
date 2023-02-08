package com.example.testtask.presentation

import com.example.testtask.domain.model.NewsItem

data class MainState(
    val listNews: List<NewsItem> = emptyList(),
    val query: String = "",
    val isError: Boolean = false,
    val isLoading: Boolean = false
)