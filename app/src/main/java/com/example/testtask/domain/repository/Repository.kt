package com.example.testtask.domain.repository

import com.example.testtask.data.remote.dto.NewsDto

interface Repository {
    suspend fun getNews(query: String): NewsDto
}