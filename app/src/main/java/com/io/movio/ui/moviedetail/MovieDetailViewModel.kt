package com.io.movio.ui.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.movio.domain.Result
import com.io.movio.domain.Movie
import com.io.movio.domain.GetMovieByIdUseCase
import kotlinx.coroutines.launch

class MovieDetailViewModel : ViewModel() {
    private val _movie = MutableLiveData<Result<Movie>>()
    val movie: LiveData<Result<Movie>> = _movie

    fun getMovie(id: Int) {
        viewModelScope.launch {
            val result = GetMovieByIdUseCase().execute(id)
            _movie.value = result
        }
    }
}