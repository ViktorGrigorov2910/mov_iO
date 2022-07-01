package com.io.movio.domain

interface UseCase<I , R>  {
    suspend fun execute(param: I):R
}