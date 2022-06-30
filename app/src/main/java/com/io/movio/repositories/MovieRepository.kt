package com.io.movio.repositories


import com.io.movio.models.Movie

object MovieRepository {
    fun getMovies(): List<Movie>  = createMovieList()

    private fun createMovieList() = listOf(
        Movie(
            "Movie1",
            "dasdasdasdasdasddasdasdasdasd",
            "12/02/2001",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(
            "Movie2",
            "asdasdasd",
            "12/02/2001",
            "Action , Comedy , Sci-Fi, Sci-Fi, Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(
            "Movie3",
            "asdasdasd",
            "02/02/1992",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(
            "Movie4",
            "asdasdasd",
            "24/11/2012",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(
            "Movie5",
            "asdasdasd",
            "22/12/1898",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill, Someone Williams , Phill Phill"
        ),
        Movie(
            "Movie6",
            "asdasdasd",
            "17/02/2012",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        ),
        Movie(
            "Movie7",
            "asdasdasd",
            "12/06/2008",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill, Someone Williams , Phill Phill, Someone Williams , Phill Phill"
        ),
        Movie(
            "Movie8",
            "asdasdasd",
            "31/03/2021",
            "Action , Comedy , Sci-Fi",
            "John Something, Someone Williams , Phill Phill"
        )
    )
}
