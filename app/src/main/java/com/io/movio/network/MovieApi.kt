package com.io.movio.network

import com.io.movio.data.models.resources.MovieDetailResource
import com.io.movio.data.models.resources.MovieListResource
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi  {
    @GET("top_rated?")
    suspend fun getMovies(@Query("api_key") key: String): MovieListResource

    @GET("{movie_id}")
    suspend fun getMovieById(@Path("movie_id") id: Int ,
                             @Query("api_key") key: String): MovieDetailResource
}