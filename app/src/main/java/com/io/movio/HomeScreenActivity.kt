package com.io.movio



import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.io.movio.model.MovieDTO



class HomeScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        //Initialization of movies
        val myListData: Array<MovieDTO> = arrayOf(
            MovieDTO(1, "Movie1", "asdasdasd"),
            MovieDTO(2, "Movie2", "asdasdasd"),
            MovieDTO(3, "Movie3", "asdasdasd"),
            MovieDTO(4, "Movie4", "asdasdasd"),
            MovieDTO(5, "Movie5", "asdasdasd"),
            MovieDTO(6, "Movie6", "asdasdasd"),
            MovieDTO(7, "Movie7", "asdasdasd"),
            MovieDTO(8, "Movie8", "asdasdasd")
        )






    }


}