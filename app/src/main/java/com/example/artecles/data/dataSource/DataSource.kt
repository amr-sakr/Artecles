package com.example.artecles.data.dataSource

import com.example.artecles.data.api.ArticlesAPI

interface IRemoteDataSource {
    val api: ArticlesAPI
}

class RemoteDataSource(override val api: ArticlesAPI) : IRemoteDataSource