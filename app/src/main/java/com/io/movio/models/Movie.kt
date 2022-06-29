package com.io.movio.models

import java.io.Serializable

data class Movie(
    val title: String,
    val description: String,
    val releaseDate: String,
    val genre: String,
    val cast: String
):Serializable