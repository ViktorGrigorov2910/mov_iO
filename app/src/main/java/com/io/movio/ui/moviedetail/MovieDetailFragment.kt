package com.io.movio.ui.moviedetail

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.io.movio.R
import com.io.movio.domain.Result
import com.io.movio.databinding.FragmentMovieDetailBinding
import com.io.movio.domain.Movie

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
            when(it){
                is Result.Success-> updateMovieDetail(it.value)
                is Result.Failure -> Toast.makeText(this.context , requireContext().getString(R.string.error_message_toast) , Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateMovieDetail(movie: Movie) {
        binding.apply {
            tvTitle.text = movie.title
            tvAvgRating.text = requireContext().getString(R.string.rating_out_of_ten , movie.rating)
            tvPopularity.text = movie.popularity.toString()
            tvDescription.text = movie.description
            tvDescription.movementMethod = ScrollingMovementMethod()
            Glide.with(root)
                .load(movie.imageUrl)
                .into(ivPoster)
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