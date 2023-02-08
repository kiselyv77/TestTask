package com.example.testtask.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testtask.common.Constants
import com.example.testtask.presentation.components.NewsItem
import com.example.testtask.presentation.components.QuerySwitch
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()

    val swipeRefreshState = rememberSwipeRefreshState(
        isRefreshing = state.isLoading
    )

    Scaffold(
        scaffoldState = scaffoldState,
    ) {
        SwipeRefresh(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding()
                ),
            state = swipeRefreshState,
            onRefresh = { viewModel.onEvent(MainEvent.GetNewsEvent(query = state.query)) }
        ) {
            Column() {
                QuerySwitch(
                    currentQuery = state.query,
                    clickApple = {viewModel.onEvent(MainEvent.GetNewsEvent(query = Constants.query_Apple))},
                    clickTesla = {viewModel.onEvent(MainEvent.GetNewsEvent(query = Constants.query_Tesla))},
                    clickBitcoin = {viewModel.onEvent(MainEvent.GetNewsEvent(query = Constants.query_Bitcoin))}
                )
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    items(state.listNews) { news ->
                        NewsItem(
                            title = news.title,
                            description = news.description,
                            imageUrl = news.urlToImage)
                    }
                }
            }

        }
    }

    if (state.isError) {
        LaunchedEffect(scaffoldState.snackbarHostState) {
            val result = scaffoldState.snackbarHostState.showSnackbar("")
            if (result == SnackbarResult.ActionPerformed) viewModel.onEvent(
                MainEvent.GetNewsEvent(
                    query = state.query
                )
            )
        }
    }
}