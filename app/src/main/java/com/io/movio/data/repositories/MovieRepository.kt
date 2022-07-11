package com.io.movio.data.repositories

import com.io.movio.common.Constant.BASE_IMAGE_URL
import com.io.movio.domain.Movie
import com.io.movio.data.resources.MovieListResource
import com.io.movio.network.RetrofitInstance
import java.time.Year


object MovieRepository {

    suspend fun getMovies(): List<Movie> =
        RetrofitInstance.api.getMovies().movieListMapping()

    suspend fun getMovieById(id: Int): Movie =
        RetrofitInstance.api.getMovieById(id).movieDetailMapping()

    suspend fun getMoviesBySearch(param: String): List<Movie> {
        return if(param == Year.now().toString()){
            RetrofitInstance.api.getMoviesBySearch(param).movieListMappingByCurrentYear()
        }else {
            RetrofitInstance.api.getMoviesBySearch(param).movieListMapping()
        }
    }
}


private fun MovieListResource.movieListMappingByCurrentYear():List<Movie> {
   return this.results.filter {
     it.releaseDate.contains( Year.now().toString())
    }.map {
        resource ->
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
}


private fun MovieListResource.MovieResource.movieDetailMapping() = Movie(
    id = id,
    title = title,
    imageUrl = "${BASE_IMAGE_URL}${posterPath}",
    description = if(overview == "")"N/A" else overview,
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
