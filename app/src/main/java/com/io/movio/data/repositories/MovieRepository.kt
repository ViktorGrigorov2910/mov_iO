package com.io.movio.data.repositories

import com.io.movio.data.models.Movie
import com.io.movio.data.models.resources.MovieDetailResource
import com.io.movio.data.models.resources.MovieListResource
import com.io.movio.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val API_KEY = "8a321dd6371474e930acd74d91c2bd84"

object MovieRepository {

    suspend fun getMovies(): List<Movie> =
        withContext(Dispatchers.IO) {
            RetrofitInstance.api.getMovies(API_KEY).movieListMapping()
        }

    suspend fun getMovieById(id: Int): Movie =
        withContext(Dispatchers.IO) {
            RetrofitInstance.api.getMovieById(id , API_KEY).movieDetailMapping()
        }
}

private fun MovieDetailResource.movieDetailMapping(): Movie {
    return Movie(
        id, title, imageUrl, description, releaseDate,
        null ,popularity, rating
    )
}

private fun MovieListResource.movieListMapping(): List<Movie> {
    val movieList = mutableListOf<Movie>()
    for (i in this.results) {
        val movie = Movie(
            i.id, i.title, i.posterPath,
            i.overview, i.releaseDate, i.genreIds ,i.popularity, i.voteAverage)
        movieList.add(movie)
    }
    return movieList
}
