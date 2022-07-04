package com.io.movio.data.repositories

import com.io.movio.data.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object MovieRepository {
     suspend fun getMovies(): List<Movie>  =
         withContext(Dispatchers.IO){
             createMovieList()
         }

    private fun createMovieList() = listOf(
        Movie( 112,
            "Movie1",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwxT4IHK0yp3vvOAHfnjdiGKEzc7SD2yHorA&usqp=CAU",
            "dasdasdasdasdasddasdasdasdasd",
            "12/02/2001",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(
            223,
            "Movie2",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwxT4IHK0yp3vvOAHfnjdiGKEzc7SD2yHorA&usqp=CAU",
            "asdasdasd",
            "12/02/2001",
            "Action , Comedy , Sci-Fi, Sci-Fi, Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(334,
            "Movie3",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwxT4IHK0yp3vvOAHfnjdiGKEzc7SD2yHorA&usqp=CAU",
            "asdasdasd",
            "02/02/1992",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie( 4,
            "Movie4",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwxT4IHK0yp3vvOAHfnjdiGKEzc7SD2yHorA&usqp=CAU",
            "asdasdasd",
            "24/11/2012",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(5,
            "Movie5",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwxT4IHK0yp3vvOAHfnjdiGKEzc7SD2yHorA&usqp=CAU",
            "asdasdasd",
            "22/12/1898",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill, Someone Williams , Phill Phill"
        ),
        Movie(6,
            "Movie6",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwxT4IHK0yp3vvOAHfnjdiGKEzc7SD2yHorA&usqp=CAU",
            "asdasdasd",
            "17/02/2012",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(7,
            "Movie7",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwxT4IHK0yp3vvOAHfnjdiGKEzc7SD2yHorA&usqp=CAU",
            "asdasdasd",
            "12/06/2008",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill, Someone Williams , Phill Phill, Someone Williams , Phill Phill"
        ),
        Movie(8,
            "Movie8",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwxT4IHK0yp3vvOAHfnjdiGKEzc7SD2yHorA&usqp=CAU",
            "asdasdasd",
            "31/03/2021",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        )
    )
}
