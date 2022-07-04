package com.io.movio.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val image_url: String,
    val description: String,
    val releaseDate: String,
    val genre: String,
    val cast: String
):Parcelable