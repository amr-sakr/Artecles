package com.example.artecles.data.repositories

import com.example.artecles.data.dataSource.RemoteDataSource
import com.example.artecles.data.models.network.ResultApi
import com.example.artecles.di.IoDispatcher
import com.example.artecles.utils.NetworkUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticlesRepository @Inject constructor(
    private val networkUtils: NetworkUtils,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource
) : IArticlesRepository {
    override fun getFirstArticlesList(): Flow<List<ResultApi>> {
        TODO("Not yet implemented")
    }

    override fun getSecondArticlesList(): Flow<List<ResultApi>> {
        TODO("Not yet implemented")
    }

}