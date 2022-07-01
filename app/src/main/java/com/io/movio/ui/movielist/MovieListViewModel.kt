package com.io.movio.ui.movielist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.movio.data.models.Movie
import com.io.movio.data.repositories.MovieRepository
import com.io.movio.domain.GetMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel : ViewModel() {
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _movieList

    init {
        viewModelScope.launch(Dispatchers.IO){
            val result =  GetMoviesUseCase(MovieRepository).getMovies()
            Log.i("Coroutine" , "Getting movies")
            withContext(Dispatchers.Main){
                _movieList.value = result
                Log.i("Coroutine" , "Returning movies")
            }

        }
        }

    }