package com.io.movio.data.models.resources

import com.google.gson.annotations.SerializedName

data class MovieListResource(
    val page: Int,
    val results: List<MovieResource>,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages:Int
)