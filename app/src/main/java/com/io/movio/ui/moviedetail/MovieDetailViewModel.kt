package com.io.movio.ui.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.movio.data.repositories.MovieRepository
import com.io.movio.domain.Result
import com.io.movio.domain.Movie
import com.io.movio.domain.GetMovieByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel@Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {
    private val _movie = MutableLiveData<Result<Movie>>()
    val movie: LiveData<Result<Movie>> = _movie

    fun getMovie(id: Int) {
        viewModelScope.launch {
            _movie.value = Result.Loading

            val result = GetMovieByIdUseCase(movieRepository).execute(id)
            _movie.value = result
        }
    }
}