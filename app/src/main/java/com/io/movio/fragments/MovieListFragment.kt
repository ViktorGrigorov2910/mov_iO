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
import com.io.movio.databinding.FragmentMovieListBinding
import com.io.movio.models.Movie



class MovieListFragment : Fragment(), Adaptor.ItemOnClickListener {
    private var movies: Array<Movie> = arrayOf()
    private lateinit var binding: FragmentMovieListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater)

        createMovieArray()
        initRecyclerView()

        return binding.root
    }


    override fun onItemClick(movie: Movie) {

        val fragment = MovieDetailFragment.newInstance(movie.title, movie.description , movie.cast)


        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.movie_list_container, fragment)
            ?.addToBackStack(null)
            ?.commit()

    }

    private fun initRecyclerView() {
        val recyclerView: RecyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = Adaptor(movies, this)

    }

    private fun createMovieArray() {

        this.movies = arrayOf(
            Movie("Movie1", "dasdasdasdasdasddasdasdasdasd", "12/02/2001", "Action , Comedy , Sci-Fi" , "John Something, Someone Williams , Phill Phill"),
            Movie("Movie2", "asdasdasd", "12/02/2001", "Action , Comedy , Sci-Fi, Sci-Fi, Sci-Fi" ,"John Something, Someone Williams , Phill Phill"),
            Movie("Movie3", "asdasdasd", "02/02/1992", "Action , Comedy , Sci-Fi" , "John Something, Someone Williams , Phill Phill"),
            Movie("Movie4", "asdasdasd", "24/11/2012", "Action , Comedy , Sci-Fi" , "John Something, Someone Williams , Phill Phill"),
            Movie("Movie5", "asdasdasd", "22/12/1898", "Action , Comedy , Sci-Fi" , "John Something, Someone Williams , Phill Phill, Someone Williams , Phill Phill"),
            Movie("Movie6", "asdasdasd", "17/02/2012", "Action , Comedy , Sci-Fi" , "John Something, Someone Williams , Phill Phill"),
            Movie("Movie7", "asdasdasd", "12/06/2008", "Action , Comedy , Sci-Fi" , "John Something, Someone Williams , Phill Phill, Someone Williams , Phill Phill, Someone Williams , Phill Phill"),
            Movie("Movie8", "asdasdasd", "31/03/2021", "Action , Comedy , Sci-Fi" , "John Something, Someone Williams , Phill Phill")
        )
    }


}