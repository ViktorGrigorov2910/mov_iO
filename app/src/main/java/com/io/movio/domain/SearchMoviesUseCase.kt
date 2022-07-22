package com.io.movio.domain

import android.util.Log
import com.io.movio.data.repositories.MovieRepositoryImpl
import java.util.*
import javax.inject.Inject


class SearchMoviesUseCase@Inject constructor(private val movieRepository: MovieRepositoryImpl ): UseCase<SearchMoviesUseCase.Params, Result<List<Movie>>> {

    override suspend fun execute(param: Params): Result<List<Movie>> {
        return try{
            if (param.year != null){
                Result.Success(movieRepository.searchMoviesByYear(param.year))
            } else {
                Result.Success(movieRepository.searchMoviesByQuery(param.queryString))
            }
        } catch (e: Exception) {
            Log.i("HiltTracker" , e.toString())
            Result.Failure(e)
        }
    }

    data class Params(
        val year: Int? = Calendar.getInstance().get(Calendar.YEAR),
        val queryString: String = "%20"
    )
}