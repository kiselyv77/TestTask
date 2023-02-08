package com.example.testtask.data.repository

import com.example.testtask.data.remote.NewsApi
import com.example.testtask.data.remote.dto.NewsDto
import com.example.testtask.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: NewsApi
) : Repository {
    override suspend fun getNews(query: String): NewsDto {
        return api.getNews(query)
    }
}