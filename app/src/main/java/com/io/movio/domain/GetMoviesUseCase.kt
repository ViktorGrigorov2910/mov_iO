package com.io.movio.domain

import com.io.movio.data.Result
import com.io.movio.data.models.Movie
import com.io.movio.data.repositories.MovieRepository
import kotlin.Exception

class GetMoviesUseCase(private val movieRepository: MovieRepository = MovieRepository) : UseCase< Unit , Result<List<Movie>>> {

    override suspend fun execute(param: Unit): Result<List<Movie>> {
        return try {
            Result.Success(movieRepository.getMovies())
        } catch (ex: Exception) {
            Result.Failure(ex)
        }
    }
}