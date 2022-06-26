package com.io.movio.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.io.movio.R
import com.io.movio.adaptor.Adaptor
import com.io.movio.models.MovieDTO


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() , Adaptor.ItemOnClickListener {
 private var movies: Array<MovieDTO> = arrayOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        createMovieArray()
        initRecyclerView(view)
        return view
    }

    private fun initRecyclerView(view: View){
       val recyclerView:RecyclerView = view.findViewById(R.id.recycler_view)
        val layoutManager =LinearLayoutManager(activity)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = Adaptor(movies , this )

    }


    private fun createMovieArray(){

          this.movies = arrayOf(
            MovieDTO("Movie1", "asdasdasd"),
            MovieDTO("Movie2", "asdasdasd"),
            MovieDTO("Movie3", "asdasdasd"),
            MovieDTO("Movie4", "asdasdasd"),
            MovieDTO("Movie5", "asdasdasd"),
            MovieDTO("Movie6", "asdasdasd"),
            MovieDTO("Movie7", "asdasdasd"),
            MovieDTO("Movie8", "asdasdasd")
        )
    }

    override fun onItemClick(movieDTO: MovieDTO) {

        val fragment = DetailFragment.newInstance(movieDTO.title)

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.frame_container, fragment)
            ?.addToBackStack(null)
            ?.commit()

    }


}