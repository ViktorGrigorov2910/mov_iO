package com.io.movio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.io.movio.fragments.MainFragment
import com.io.movio.models.MovieDTO


class HomeScreenActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val fragment = MainFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()


    }


}