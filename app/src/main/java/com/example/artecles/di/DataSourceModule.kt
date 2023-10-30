package com.example.artecles.di

import com.example.artecles.data.api.ArticlesAPI
import com.example.artecles.data.dataSource.IRemoteDataSource
import com.example.artecles.data.dataSource.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Provides
    @Singleton
    fun bindIRemoteDataSource(
        api: ArticlesAPI
    ): IRemoteDataSource {
        return RemoteDataSource(api)
    }
}