package com.io.movio.domain

import kotlin.Exception

sealed class Result<out T> {
    class IsLoading<T> : Result<T>()
    data class Success<out T>(val value: T) : Result<T>()
    data class Failure(val error: Exception) : Result<Nothing>()
}
