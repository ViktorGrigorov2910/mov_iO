package com.io.movio.domain

import com.io.movio.data.Result
import com.io.movio.data.models.Movie
import com.io.movio.data.repositories.MovieRepository
import kotlin.Exception

class GetMovieByIdUseCase(private val movieRepository: MovieRepository = MovieRepository): UseCase<Int , Result<Movie>>{
    override suspend fun execute(id: Int): Result<Movie> {
        return try {
            Result.Success(movieRepository.getMovies().first{it.id == id })
        }catch (ex: Exception){
            Result.Failure(ex)
        }
    }
}