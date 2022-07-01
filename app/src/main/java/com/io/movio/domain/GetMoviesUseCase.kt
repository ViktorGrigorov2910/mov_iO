package com.io.movio.domain

import com.io.movio.data.models.Movie
import com.io.movio.data.repositories.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun getMovies(): List<Movie> = movieRepository.getMovies()

}