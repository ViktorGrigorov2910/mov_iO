package com.io.movio.ui.moviedetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.movio.data.models.Movie
import com.io.movio.data.repositories.MovieRepository
import com.io.movio.domain.GetMovieByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel : ViewModel() {
    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    fun getMovie(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
               val result = GetMovieByIdUseCase(MovieRepository).getMovieById(id)
                Log.i("Coroutine" , "Getting movie by id")
                withContext(Dispatchers.Main){
                    _movie.value = result!!
                    Log.i("Coroutine" , "Returing movie by id ")
                }
            }
        }


    }

