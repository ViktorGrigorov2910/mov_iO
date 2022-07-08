package com.io.movio.data.repositories

import com.io.movio.common.Constant.BASE_IMAGE_URL
import com.io.movio.domain.Movie
import com.io.movio.data.resources.MovieListResource
import com.io.movio.network.RetrofitInstance
import kotlinx.coroutines.delay


object MovieRepository {

    suspend fun getMovies(): List<Movie> =
        RetrofitInstance.api.getMovies().movieListMapping()

    suspend fun getMovieById(id: Int): Movie =
        RetrofitInstance.api.getMovieById(id).movieDetailMapping()

    suspend fun getMoviesBySearch(param: String): List<Movie> {
        delay(4000)
        return if(param == "2022"){
            RetrofitInstance.api.getMoviesBySearch(param).movieListMapping()
        }else {
            RetrofitInstance.api.getMoviesBySearch(param).movieListMapping()
        }
    }
}

//private fun MovieListResource.movieListMappingByCurrentYear():List<Movie> {
//    var filteredMovieList = this.results.map { resource ->
//        if (resource.releaseDate.contains("2022")) {
//            Movie(
//                id = resource.id,
//                title = resource.title,
//                imageUrl = "${BASE_IMAGE_URL}${resource.posterPath}",
//                description = resource.overview,
//                releaseDate = resource.releaseDate,
//                genre = resource.genreIds ?: emptyList(),
//                popularity = resource.popularity,
//                rating = resource.voteAverage
//            )
//        }
//    }
//    return filteredMovieList
//}


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
