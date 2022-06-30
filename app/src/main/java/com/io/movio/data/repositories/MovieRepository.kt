package com.io.movio.data.repositories

import com.io.movio.data.models.Movie

object MovieRepository {
    fun getMovies(): List<Movie>  = createMovieList()

    private fun createMovieList() = listOf(
        Movie( 1,
            "Movie1",
            "dasdasdasdasdasddasdasdasdasd",
            "12/02/2001",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(
            2,
            "Movie2",
            "asdasdasd",
            "12/02/2001",
            "Action , Comedy , Sci-Fi, Sci-Fi, Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(3,
            "Movie3",
            "asdasdasd",
            "02/02/1992",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie( 4,
            "Movie4",
            "asdasdasd",
            "24/11/2012",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(5,
            "Movie5",
            "asdasdasd",
            "22/12/1898",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill, Someone Williams , Phill Phill"
        ),
        Movie(6,
            "Movie6",
            "asdasdasd",
            "17/02/2012",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(7,
            "Movie7",
            "asdasdasd",
            "12/06/2008",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill, Someone Williams , Phill Phill, Someone Williams , Phill Phill"
        ),
        Movie(8,
            "Movie8",
            "asdasdasd",
            "31/03/2021",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        )
    )
}
