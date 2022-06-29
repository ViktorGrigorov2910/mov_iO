package com.io.movio.fragments

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.io.movio.databinding.FragmentMovieDetailBinding
import com.io.movio.models.Movie

// the fragment initialization parameters
private const val ARG_MOVIE = "movie"


class MovieDetailFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailBinding
    private lateinit var movie: Movie


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tvTitle.text = movie.title
            tvCast.text = movie.cast
            tvDescription.text = movie.description
            tvDescription.movementMethod = ScrollingMovementMethod()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentMovieDetailBinding.inflate(inflater , container , false)

        arguments?.let {
            movie = it.getSerializable(ARG_MOVIE) as Movie
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        fun newInstance(movie: Movie) =
            MovieDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("movie" , movie)
                }
            }
    }

}