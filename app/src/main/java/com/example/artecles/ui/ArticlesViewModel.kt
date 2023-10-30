package com.example.artecles.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artecles.di.MainDispatcher
import com.example.artecles.useCases.GetCompiledArticles
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val articlesUseCase: GetCompiledArticles,
    @MainDispatcher
    private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _resultsState = MutableStateFlow<ArticlesUiState>(ArticlesUiState.Initial)
    val resultsState = _resultsState.asStateFlow()

    private val _error = Channel<ArticlesUiState>()
    val error = _error.receiveAsFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        viewModelScope.launch {
            _error.send(ArticlesUiState.Error(throwable.message))
        }
    }


    init {
        gitArticles()
    }

    private fun gitArticles() {
        viewModelScope.launch(handler + mainDispatcher) {
            articlesUseCase().collect { articles ->
                _resultsState.emit(
                    ArticlesUiState.ArticlesLoaded(articles)
                )
            }
        }
    }
}