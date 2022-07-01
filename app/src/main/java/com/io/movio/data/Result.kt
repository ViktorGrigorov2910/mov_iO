package com.io.movio.data

import java.lang.Exception


sealed class Result<out T>  {
    data class Success<out T>(val value: T): Result<T>()
    data class Failure(val error: Exception): Result<Nothing>()
}
