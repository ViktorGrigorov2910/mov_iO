package com.io.movio.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.io.movio.R
import com.io.movio.adaptor.MoviesAdapter
import com.io.movio.databinding.FragmentMovieListBinding
import com.io.movio.models.Movie
import com.io.movio.viewmodels.MovieListViewModel

class MovieListFragment : Fragment(), MoviesAdapter.ItemOnClickListener {

    private lateinit var binding: FragmentMovieListBinding
    private val viewModel: MovieListViewModel by lazy {  ViewModelProvider(this@MovieListFragment)[MovieListViewModel::class.java] }
    private var adapter = MoviesAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ViewModel must be here
        viewModel.getMovieList().observe(this) {
            adapter.update(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
    }

    override fun onItemClick(movie: Movie) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MovieDetailFragment.newInstance(movie))
            .addToBackStack(javaClass::class.java.name)
            .commit()
    }
}