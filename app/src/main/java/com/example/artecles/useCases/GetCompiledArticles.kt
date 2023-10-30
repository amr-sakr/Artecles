package com.example.artecles.useCases

import com.example.artecles.data.models.view.Result
import com.example.artecles.data.models.view.toResult
import com.example.artecles.data.repositories.IArticlesRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.zip

import javax.inject.Inject

@ViewModelScoped
class GetCompiledArticles @Inject constructor(
    private val repository: IArticlesRepository
) {
    private fun getFirstArticlesList(): Flow<List<Result>> = repository.getFirstArticlesList().map {
        it.map { results ->
            results.toResult()
        }
    }

    private fun getSecondArticlesList(): Flow<List<Result>> =
        repository.getFirstArticlesList().map {
            it.map { results ->
                results.toResult()
            }
        }


    operator fun invoke() = flow<List<Result>> {
        val merged = merge(getFirstArticlesList(), getSecondArticlesList()).toList()
        emit(merged.flatten())
    }

}