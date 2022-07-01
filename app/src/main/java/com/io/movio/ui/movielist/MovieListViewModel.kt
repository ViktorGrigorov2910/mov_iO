package com.io.movio.ui.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.io.movio.data.models.Movie
import com.io.movio.data.repositories.MovieRepository
import com.io.movio.domain.GetMoviesUseCase

class MovieListViewModel : ViewModel() {
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _movieList

    init {
        _movieList.value = GetMoviesUseCase(MovieRepository).getMovies()
        }
    }