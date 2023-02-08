package com.example.testtask.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.common.Constants
import com.example.testtask.common.Resource
import com.example.testtask.domain.use_case.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MainState())
    val state = _state

    init{
        getNews(Constants.query_Apple)
    }

    fun onEvent(event: MainEvent){
        when(event){
            is MainEvent.GetNewsEvent -> {
                getNews(event.query)
            }
        }
    }

    private fun getNews(query: String) {
        _state.value = _state.value.copy(query = query)
        viewModelScope.launch {
            getNewsUseCase(query).collect{ result ->
                when(result){
                    is Resource.Success -> {
                        result.data?.let { news ->
                            Log.d("asdadsadsadasd", news.articles.size.toString())
                            _state.value = _state.value.copy(listNews = news.articles, isError = false, isLoading = false)
                        }
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(isLoading = true, isError = false)
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(isLoading = false, isError = true)
                    }
                }
            }
        }
    }
}