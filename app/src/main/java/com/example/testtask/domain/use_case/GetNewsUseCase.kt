package com.example.testtask.domain.use_case

import android.util.Log
import com.example.testtask.domain.model.News
import com.example.testtask.common.Resource
import com.example.testtask.data.mappers.toNews
import com.example.testtask.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<Resource<News>> = flow{
        try{
            emit(Resource.Loading<News>())
            val news = repository.getNews(query)
            emit(Resource.Success<News>(news.toNews()))
        } catch (exception: HttpException){
            val debugMessage = exception.message
            val massage = exception.response()?.errorBody()?.charStream()?.readText()?:"Не удалось распознать ошибку"
            emit(Resource.Error<News>(massage))
        }catch (exception: IOException){
            val debugMessage = exception.message
            val message = "Ошибка подключения проверьте подключение к сети"
            Log.d("debugMessage", debugMessage.toString())
            emit(Resource.Error<News>(message.toString()))
        }
    }
}