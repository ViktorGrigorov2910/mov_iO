package com.io.movio.domain

import com.io.movio.data.Result
import com.io.movio.data.models.Movie
import com.io.movio.data.repositories.MovieRepository
import java.lang.Exception

class GetMoviesUseCase : UseCase<MovieRepository, Result<List<Movie>>> {

    override suspend fun execute(param: MovieRepository): Result<List<Movie>> {
        return try {
            Result.Success(param.getMovies())
        } catch (ex: Exception) {
            Result.Failure(ex)
        }
    }
}