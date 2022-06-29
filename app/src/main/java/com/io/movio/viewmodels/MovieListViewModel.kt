package com.io.movio.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.io.movio.models.Movie
import com.io.movio.repositories.MovieRepository

class MovieListViewModel: ViewModel() {

    private val _movieList = MutableLiveData<List<Movie>>()
    fun getMovieList() :LiveData<List<Movie>> = _movieList


    init {
        _movieList.value = MovieRepository.getMovies()
    }



}