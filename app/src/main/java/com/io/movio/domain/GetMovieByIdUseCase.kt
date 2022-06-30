package com.io.movio.domain

import com.io.movio.data.models.Movie
import com.io.movio.data.repositories.MovieRepository

class GetMovieByIdUseCase(private val movieRepository:MovieRepository){

    operator fun invoke(id: Int):Movie{
        return getMovieById(id)
    }

    fun getMovieById(id:Int):Movie{
      return movieRepository.getMovies()[id]
    }
}