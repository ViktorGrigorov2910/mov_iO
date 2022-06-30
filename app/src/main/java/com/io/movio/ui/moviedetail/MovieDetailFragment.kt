package com.io.movio.ui.moviedetail

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.io.movio.databinding.FragmentMovieDetailBinding
import com.io.movio.data.models.Movie

// the fragment initialization parameters
private const val ARG_MOVIE_ID = "movie_id"

class MovieDetailFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailBinding
    private val viewModel: MovieDetailViewModel by lazy { ViewModelProvider(this@MovieDetailFragment)[MovieDetailViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMovieDetailBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovie(requireArguments().getInt(ARG_MOVIE_ID))
        viewModel.movie.observe(viewLifecycleOwner) {
            updateMovieDetail(it)
        }
    }

    private fun updateMovieDetail(movie: Movie) {
        binding.apply {
            tvTitle.text = movie.title
            tvCast.text = movie.cast
            tvDescription.text = movie.description
            tvDescription.movementMethod = ScrollingMovementMethod()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        fun newInstance(id: Int) =
            MovieDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_MOVIE_ID, id)
                }
            }
    }
}