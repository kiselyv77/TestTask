package com.example.testtask.presentation

sealed class MainEvent() {
    data class GetNewsEvent(val query: String): MainEvent()
}