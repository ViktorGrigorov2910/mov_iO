package com.io.movio.domain

import com.io.movio.data.repositories.MovieRepositoryImpl
import javax.inject.Inject
import kotlin.Exception

class GetMoviesUseCase @Inject constructor(private val movieRepository: MovieRepositoryImpl) : UseCase< Unit , Result<List<Movie>>> {
    override suspend fun execute(param: Unit): Result<List<Movie>> {
        return try {
            Result.Success(movieRepository.getMovies())
        } catch (ex: Exception) {
            Result.Failure(ex)
        }
    }
}