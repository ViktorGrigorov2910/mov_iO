package com.io.movio.ui.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.movio.domain.Result
import com.io.movio.domain.Movie
import com.io.movio.domain.GetMoviesUseCase
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
    private val _movieList = MutableLiveData<Result<List<Movie>>>()
    val movieList: LiveData<Result<List<Movie>>> = _movieList

    init {
        viewModelScope.launch {
            val result = GetMoviesUseCase().execute(Unit)
            _movieList.value = result
        }
    }
}