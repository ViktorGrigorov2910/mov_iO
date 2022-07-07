package com.io.movio.ui.moviesearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.movio.domain.GetMoviesUseCase
import com.io.movio.domain.Movie
import com.io.movio.domain.Result
import kotlinx.coroutines.launch

class MovieSearchViewModel : ViewModel() {
    private val _movieResultList = MutableLiveData<Result<List<Movie>>>()
    val movieResultList: LiveData<Result<List<Movie>>> = _movieResultList

    init {
        viewModelScope.launch {
            //TODO: Change use case to GetMoviesBySearch? !!Default search param = current year!!
            val result = GetMoviesUseCase().execute(Unit)
            _movieResultList.value = result
        }
    }
}