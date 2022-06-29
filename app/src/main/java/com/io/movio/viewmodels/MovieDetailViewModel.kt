package com.io.movio.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.io.movio.models.Movie

class MovieDetailViewModel: ViewModel() {
    private  val _movie = MutableLiveData<Movie>()

    fun getMovieClicked(movie: Movie):LiveData<Movie> {
        _movie.value = movie

        return _movie
    }



}