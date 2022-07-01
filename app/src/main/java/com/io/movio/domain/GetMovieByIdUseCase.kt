package com.io.movio.domain

import com.io.movio.data.repositories.MovieRepository

class GetMovieByIdUseCase(private val movieRepository:MovieRepository){

    operator fun invoke(id:Int) = movieRepository.getMovies().find { it.id == id }
}