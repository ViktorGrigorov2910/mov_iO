package com.io.movio.ui.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.io.movio.R
import com.io.movio.domain.Result
import com.io.movio.ui.movielist.adapter.MoviesAdapter
import com.io.movio.databinding.FragmentMovieListBinding
import com.io.movio.ui.moviedetail.MovieDetailFragment

class MovieListFragment : Fragment(), MoviesAdapter.ItemOnClickListener {

    private lateinit var binding: FragmentMovieListBinding
    private val viewModel: MovieListViewModel by lazy {  ViewModelProvider(this@MovieListFragment)[MovieListViewModel::class.java] }
    private var adapter = MoviesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentMovieListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter

        viewModel.movieList.observe(viewLifecycleOwner) {
            when(it){
                is Result.Success -> adapter.update(it.value)
                is Result.Failure -> Toast.makeText(this.context , requireContext().getString(R.string.error_message_toast)  , Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onItemClick(id: Int) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MovieDetailFragment.newInstance(id))
            .addToBackStack(javaClass::class.java.name)
            .commit()
    }
}