package com.example.artecles.data.repositories

import com.example.artecles.data.models.network.ResultApi
import kotlinx.coroutines.flow.Flow

interface IArticlesRepository {
    fun getFirstArticlesList(): Flow<List<ResultApi>>

    fun getSecondArticlesList(): Flow<List<ResultApi>>
}