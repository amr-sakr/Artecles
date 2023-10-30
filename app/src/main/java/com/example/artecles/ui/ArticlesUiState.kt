package com.example.artecles.ui

import com.example.artecles.data.models.view.Result

sealed class ArticlesUiState {
    data object Initial : ArticlesUiState()
    data object Loading : ArticlesUiState()

    data class Error(val error: String?) : ArticlesUiState()

    data class ArticlesLoaded(val data: List<Result>) : ArticlesUiState()
}