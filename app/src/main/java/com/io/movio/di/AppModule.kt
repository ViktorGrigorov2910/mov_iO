package com.io.movio.di

import com.io.movio.data.MovieApi
import com.io.movio.data.repositories.MovieRepository
import com.io.movio.data.repositories.MovieRepositoryImpl
import com.io.movio.network.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMovieRepository(repo: MovieRepositoryImpl):MovieRepository =repo

    @Provides
    @Singleton
    fun provideApi():MovieApi = RetrofitInstance.api

}