package com.io.movio.ui.moviesearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.movio.domain.Movie
import com.io.movio.domain.Result
import com.io.movio.domain.SearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val SEARCH_PARAM_MIN_LENGTH = 2
@HiltViewModel
class MovieSearchViewModel@Inject constructor(private val searchMoviesUseCase: SearchMoviesUseCase): ViewModel() {

    private val _movieResultList = MutableLiveData<Result<List<Movie>>>()
    val movieResultList: LiveData<Result<List<Movie>>> = _movieResultList
    private var lastSearch: String? = null

    init { initialSearch() }

    fun searchMovie(searchParam: String) {
        if (searchParam.isEmpty()) {
            initialSearch()
        } else if (searchParam.length > SEARCH_PARAM_MIN_LENGTH) {
            searchMovieByName(searchParam)
        }
    }

    private fun initialSearch() {
        viewModelScope.launch {
            _movieResultList.value = Result.Loading
            _movieResultList.value = searchMoviesUseCase.execute(SearchMoviesUseCase.Params())
        }
    }

    private fun searchMovieByName(param: String) {
        if (lastSearch == param) return

        lastSearch = param
        viewModelScope.launch {
            _movieResultList.value = Result.Loading

            val queryParams = SearchMoviesUseCase.Params(null, param)
            _movieResultList.value = searchMoviesUseCase.execute(queryParams)
        }
    }
}