package com.io.movio.ui.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.movio.data.Result
import com.io.movio.data.models.Movie
import com.io.movio.data.repositories.MovieRepository
import com.io.movio.domain.GetMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel : ViewModel() {
    private val _movieList = MutableLiveData<Result<List<Movie>>>()
    val movieList: LiveData<Result<List<Movie>>> = _movieList

    init {
        viewModelScope.launch(Dispatchers.IO){
            val result = GetMoviesUseCase().execute(MovieRepository)
            Result.Success(result)
            withContext(Dispatchers.Main){
              _movieList.value =  result
            }
        }
        }

    }