package com.io.movio.domain

import android.util.Log
import com.io.movio.data.repositories.MovieRepository

class GetMoviesBySearch(private val movieRepository:MovieRepository = MovieRepository):UseCase <String , Result<List<Movie>>> {
    override suspend fun execute(param: String): Result<List<Movie>> {
        return try {
            Result.Success(movieRepository.getMoviesBySearch(param))
        } catch (ex: Exception) {
            Log.i("Kur" , ex.message.toString())
            Result.Failure(ex)
        }
    }
}
