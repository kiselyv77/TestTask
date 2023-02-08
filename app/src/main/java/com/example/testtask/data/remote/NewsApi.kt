package com.example.testtask.data.remote

import com.example.testtask.data.remote.dto.NewsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {
    @GET("https://newsapi.org/v2/everything?apiKey=8f0047a52975437e90a58918c4fa2dc2")
    suspend fun getNews(@Query("q") query: String): NewsDto
}