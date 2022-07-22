package com.io.movio.data.repositories

import com.io.movio.domain.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>

    suspend fun getMovieById(id: Int): Movie

    suspend fun searchMoviesByYear(releaseDate: Int): List<Movie>

    suspend fun searchMoviesByQuery(query: String): List<Movie>
}