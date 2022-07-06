package com.io.movio.data.models.resources

import com.google.gson.annotations.SerializedName

data class MovieDetailResource(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Nothing? = null,
    val budget: Int,
    val homepage: String?,
    val id: Int,
    val imdbId: Int?,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("overview")
    val description: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val imageUrl: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("production_companies")
    val productionCompanies: List<Any>,
    @SerializedName("production_countries")
    val productionCountries: List<Any>,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runTime: Int?,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<Any>,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val rating: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
)
