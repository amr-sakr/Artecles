package com.example.artecles.data.dataSource

import com.example.artecles.data.api.ArticlesAPI
import javax.inject.Inject

interface IRemoteDataSource {
    val api: ArticlesAPI
}

class RemoteDataSource @Inject constructor(override val api: ArticlesAPI) : IRemoteDataSource