package com.io.movio.data

import com.io.movio.common.Constant
import com.io.movio.data.resources.MovieListResource
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/top_rated?api_key=${Constant.API_KEY}")
    suspend fun getMovies(): MovieListResource

    @GET("movie/{movie_id}?api_key=${Constant.API_KEY}")
    suspend fun getMovieById(@Path("movie_id") id: Int): MovieListResource.MovieResource

    @GET("search/movie?api_key=${Constant.API_KEY}")
    suspend fun getMoviesBySearch(
        @Query("query") input: String? = "%20",
        @Query("primary_release_year") releaseDate: Int? = null
    ): MovieListResource
}