package com.io.movio.data.repositories

import com.io.movio.common.Constant.BASE_IMAGE_URL
import com.io.movio.domain.Movie
import com.io.movio.data.resources.MovieListResource
import com.io.movio.network.RetrofitInstance


object MovieRepository {

    suspend fun getMovies(): List<Movie> =
        RetrofitInstance.api.getMovies().movieListMapping()

    suspend fun getMovieById(id: Int): Movie =
        RetrofitInstance.api.getMovieById(id).movieDetailMapping()

    suspend fun getMoviesBySearch(param: String): List<Movie> =
        RetrofitInstance.api.getMoviesBySearch(param).movieListMapping()
}

private fun MovieListResource.MovieResource.movieDetailMapping() = Movie(
        id = id,
        title = title,
        imageUrl = "${BASE_IMAGE_URL}${posterPath}",
        description = overview,
        releaseDate = releaseDate,
        genre = genreIds ?: emptyList(),
        popularity = popularity,
        rating = voteAverage
    )

private fun MovieListResource.movieListMapping() = this.results.map { resource ->
    Movie(
        id = resource.id,
        title = resource.title,
        imageUrl = "${BASE_IMAGE_URL}${resource.posterPath}",
        description = resource.overview,
        releaseDate = resource.releaseDate,
        genre = resource.genreIds ?: emptyList(),
        popularity = resource.popularity,
        rating = resource.voteAverage
    )
}
