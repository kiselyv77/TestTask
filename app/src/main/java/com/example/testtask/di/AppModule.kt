package com.example.testtask.di

import com.example.testtask.common.Constants.BASE_URL
import com.example.testtask.data.remote.NewsApi
import com.example.testtask.data.repository.RepositoryImpl
import com.example.testtask.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCovidApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRepository(api: NewsApi): Repository {
        return RepositoryImpl(api)
    }

}