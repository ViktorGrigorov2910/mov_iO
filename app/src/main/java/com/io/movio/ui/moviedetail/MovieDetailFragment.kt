package com.io.movio.ui.moviedetail

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.io.movio.R
import com.io.movio.databinding.FragmentMovieDetailBinding
import com.io.movio.domain.Movie
import com.io.movio.domain.Result


class MovieDetailFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailBinding
    private val viewModel: MovieDetailViewModel by lazy { ViewModelProvider(this@MovieDetailFragment)[MovieDetailViewModel::class.java] }
    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMovieDetailBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMovie(args.movieId)
        viewModel.movie.observe(viewLifecycleOwner) {
            when(it){
                is Result.IsLoading -> binding.loadingBar.visibility = View.VISIBLE
                is Result.Success->{
                    binding.loadingBar.visibility = View.INVISIBLE
                    updateMovieDetail(it.value)
                }
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

}