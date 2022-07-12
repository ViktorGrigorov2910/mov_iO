package com.io.movio.domain

import com.io.movio.data.repositories.MovieRepository
import java.util.*

class SearchMoviesUseCase : UseCase<SearchMoviesUseCase.Params, Result<List<Movie>>> {

    override suspend fun execute(param: Params): Result<List<Movie>> {
        return try{
            if (param.year != null){
                Result.Success(MovieRepository.searchMoviesByYear(param.year))
            } else {
                Result.Success(MovieRepository.searchMoviesByQuery(param.queryString))
            }
        } catch (e: Exception) {
            Result.Failure(e)
        }
    }

    data class Params(
        val year: Int? = Calendar.getInstance().get(Calendar.YEAR),
        val queryString: String = "%20"
    )
}