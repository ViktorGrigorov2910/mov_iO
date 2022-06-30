package com.io.movio.ui.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.io.movio.data.models.Movie
import com.io.movio.data.repositories.MovieRepository
import com.io.movio.domain.GetMovieByIdUseCase

class MovieDetailViewModel : ViewModel() {
    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    fun getMovie(id: Int){
   _movie.value = GetMovieByIdUseCase(MovieRepository)(id)!!
    }
}