package com.io.movio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.io.movio.fragments.MovieListFragment


class HomeScreenActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val fragment = MovieListFragment()
        supportFragmentManager.beginTransaction().replace(R.id.movie_list_container, fragment).commit()


    }


}