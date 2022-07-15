package com.io.movio.data.repositories

import com.io.movio.common.Constant.BASE_IMAGE_URL
import com.io.movio.domain.Movie
import com.io.movio.data.resources.MovieListResource
import com.io.movio.network.RetrofitInstance
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
object MovieRepository{

    private val moviesByDate: MutableMap<Int, List<Movie>> = mutableMapOf()

    suspend fun getMovies(): List<Movie> =
        RetrofitInstance.api.getMovies().movieListMapping()

    suspend fun getMovieById(id: Int): Movie =
        RetrofitInstance.api.getMovieById(id).movieDetailMapping()

    suspend fun searchMoviesByYear(releaseDate: Int): List<Movie> =
        if (moviesByDate.containsKey(releaseDate)) {
            moviesByDate.getValue(releaseDate)
        } else {
            val movies = RetrofitInstance.api.getMoviesBySearch(releaseDate = releaseDate).movieListMapping()
            moviesByDate[releaseDate] = movies
            movies
        }

    suspend fun searchMoviesByQuery(query: String): List<Movie> =
        RetrofitInstance.api.getMoviesBySearch(input = query).movieListMapping()
}

private fun MovieListResource.MovieResource.movieDetailMapping() = Movie(
    id = id,
    title = title,
    imageUrl = "${BASE_IMAGE_URL}${posterPath}",
    description = overview.ifEmpty { "N/A" },
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
