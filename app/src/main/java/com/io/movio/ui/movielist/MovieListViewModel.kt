package com.io.movio.ui.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.movio.domain.Result
import com.io.movio.domain.Movie
import com.io.movio.domain.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val useCase: GetMoviesUseCase): ViewModel() {
    private val _movieList = MutableLiveData<Result<List<Movie>>>()
    val movieList: LiveData<Result<List<Movie>>> = _movieList

    init {
        viewModelScope.launch {
            val result = useCase.execute(Unit)
            _movieList.value = result
        }
    }
}