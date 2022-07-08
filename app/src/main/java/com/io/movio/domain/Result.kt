package com.io.movio.domain

import kotlin.Exception

sealed class Result<out T> {
    data class Success<out T>(val value: T) : Result<T>()
    data class Failure(val error: Exception) : Result<Nothing>()
    //data class Loading(val isLoading: Boolean)
}
