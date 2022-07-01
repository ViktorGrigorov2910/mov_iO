package com.io.movio.ui.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.movio.data.Result
import com.io.movio.data.models.Movie
import com.io.movio.domain.GetMovieByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel : ViewModel() {
    private val _movie = MutableLiveData<Result<Movie>>()
    val movie: LiveData<Result<Movie>> = _movie

    fun getMovie(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
               val result = GetMovieByIdUseCase().execute(id)
                Result.Success(result)
                withContext(Dispatchers.Main){
                    _movie.value = result
                }
            }
        }
    }