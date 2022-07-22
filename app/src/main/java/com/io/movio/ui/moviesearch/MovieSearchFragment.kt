package com.io.movio.ui.moviesearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.io.movio.R
import com.io.movio.common.Constant.DELAY_FOR_SEARCH
import com.io.movio.databinding.FragmentMovieSearchBinding
import com.io.movio.domain.Result
import com.io.movio.ui.adapter.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.concurrent.schedule

@AndroidEntryPoint
class MovieSearchFragment: Fragment(), MoviesAdapter.ItemOnClickListener {

    private lateinit var binding: FragmentMovieSearchBinding
    private val viewModel: MovieSearchViewModel by viewModels()
    private var adapter = MoviesAdapter(this)
    private var timer = Timer()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMovieSearchBinding.inflate(inflater).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resultList.adapter = adapter

        binding.edtSearchBar.doAfterTextChanged { text ->
            timer.cancel()
            timer = Timer().apply {
                schedule(DELAY_FOR_SEARCH) {
                    viewModel.searchMovie(text.toString())
                }
            }
        }

        viewModel.movieResultList.observe(viewLifecycleOwner) {
            when (it) {
                is Result.Loading -> {
                    binding.apply {
                        resultList.visibility = View.INVISIBLE
                        loadingBar.visibility = View.VISIBLE
                    }
                }
                is Result.Success -> {
                    binding.apply {
                        resultList.visibility = View.VISIBLE
                        loadingBar.visibility = View.INVISIBLE
                    }
                    binding.resultList.scrollToPosition(0)
                    adapter.update(it.value)
                }
                is Result.Failure -> {
                    Toast.makeText(
                        requireContext(),
                        requireContext().getString(R.string.error_message_toast),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onItemClick(id: Int) = Navigation
        .findNavController(requireView()).navigate(MovieSearchFragmentDirections.actionMovieSearchFragmentToMovieDetailFragment(id))
}

