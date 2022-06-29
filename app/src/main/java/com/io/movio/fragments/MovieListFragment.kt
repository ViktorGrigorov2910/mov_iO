package com.io.movio.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.io.movio.R
import com.io.movio.adaptor.MoviesAdapter
import com.io.movio.databinding.FragmentMovieListBinding
import com.io.movio.models.Movie

class MovieListFragment : Fragment(), MoviesAdapter.ItemOnClickListener {

    private lateinit var binding: FragmentMovieListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMovieListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createMovieArray()
        initRecyclerView()
    }

    override fun onItemClick(movie: Movie) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MovieDetailFragment.newInstance(movie))
            .addToBackStack(javaClass::class.java.name)
            .commit()
    }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = MoviesAdapter(createMovieArray(), this)
    }

    private fun createMovieArray() = arrayOf(
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