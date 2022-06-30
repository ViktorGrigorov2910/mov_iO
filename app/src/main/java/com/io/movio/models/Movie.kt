package com.io.movio.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val description: String,
    val releaseDate: String,
    val genre: String,
    val cast: String
):Parcelable