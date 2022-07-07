package com.io.movio.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val description: String,
    val releaseDate: String,
    val genre: List<Int>,
    val popularity: Double ,
    val rating:Double
) : Parcelable