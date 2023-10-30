package com.example.artecles.data.repositories

import com.example.artecles.data.dataSource.RemoteDataSource
import com.example.artecles.data.models.network.ResultApi
import com.example.artecles.di.IoDispatcher
import com.example.artecles.utils.NetworkUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticlesRepository @Inject constructor(
    private val networkUtils: NetworkUtils,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource
) : IArticlesRepository {
    override fun getFirstArticlesList(): Flow<List<ResultApi>> = flow {
        try {
            if (!networkUtils.isConnectedToNetwork()) {
                throw IOException("Please Check Your Internet Connection")
            }

            emit(
                with(remoteDataSource.api.getArticles(1)) {
                    if (isSuccessful) body()?.results ?: listOf()
                    else throw IOException("Please Check Your Internet Connection")
                }
            )

        } catch (throwable: Throwable) {
            throw throwable
        }
    }.flowOn(ioDispatcher)

    override fun getSecondArticlesList(): Flow<List<ResultApi>> = flow {
        try {
            if (!networkUtils.isConnectedToNetwork()) {
                throw IOException("Please Check Your Internet Connection")
            }

            emit(
                with(remoteDataSource.api.getArticles(30)) {
                    if (isSuccessful) body()?.results ?: listOf()
                    else throw IOException("Please Check Your Internet Connection")
                }
            )

        } catch (throwable: Throwable) {
            throw throwable
        }
    }.flowOn(ioDispatcher)

}