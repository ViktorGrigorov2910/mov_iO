package com.io.movio.domain

import com.io.movio.data.repositories.MovieRepository

class GetMoviesBySearchUseCase(private val movieRepository:MovieRepository = MovieRepository):UseCase <String , Result<List<Movie>>> {
    override suspend fun execute(param: String): Result<List<Movie>> {
        return try {
            Result.Success(movieRepository.getMoviesBySearch(param))
        } catch (ex: Exception) {
            Result.Failure(ex)
        }
    }
}
