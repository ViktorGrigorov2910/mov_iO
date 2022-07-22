package com.io.movio.data.repositories

import com.io.movio.common.Constant.BASE_IMAGE_URL
import com.io.movio.data.MovieApi
import com.io.movio.domain.Movie
import com.io.movio.data.resources.MovieListResource
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MovieApi) : MovieRepository {
    private val moviesByDate: MutableMap<Int, List<Movie>> = mutableMapOf()

    override suspend fun getMovies(): List<Movie> =
        api.getMovies().movieListMapping()

    override suspend fun getMovieById(id: Int): Movie =
        api.getMovieById(id).movieDetailMapping()

    override suspend fun searchMoviesByYear(releaseDate: Int): List<Movie> =
        if (moviesByDate.containsKey(releaseDate)) {
            moviesByDate.getValue(releaseDate)
        } else {
            val movies = api.getMoviesBySearch(releaseDate = releaseDate).movieListMapping()
            moviesByDate[releaseDate] = movies
            movies
        }

    override suspend fun searchMoviesByQuery(query: String): List<Movie> =
        api.getMoviesBySearch(input = query).movieListMapping()
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
