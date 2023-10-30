package com.example.artecles.di

import com.example.artecles.data.repositories.ArticlesRepository
import com.example.artecles.data.repositories.IArticlesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoriesModule {

    @Provides
    @Singleton
    fun provideArticlesRepository(repository: ArticlesRepository): IArticlesRepository = repository

}