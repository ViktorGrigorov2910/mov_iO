package com.io.movio.ui.moviesearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.movio.domain.GetMoviesBySearch
import com.io.movio.domain.Movie
import com.io.movio.domain.Result
import kotlinx.coroutines.launch

class MovieSearchViewModel : ViewModel() {
    private val _movieResultList = MutableLiveData<Result<List<Movie>>>()
    val movieResultList: LiveData<Result<List<Movie>>> = _movieResultList

    fun getMoviesBySearch(param: String) {
        viewModelScope.launch {
            //TODO: !!Default search param = current year!!
            val result = GetMoviesBySearch().execute(param)
            _movieResultList.value = result
        }
    }
}