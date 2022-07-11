package com.io.movio.ui.moviesearch

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.io.movio.R
import com.io.movio.databinding.FragmentMovieSearchBinding
import com.io.movio.domain.Result
import com.io.movio.ui.adapter.MoviesAdapter
import okhttp3.internal.wait
import java.sql.Time
import java.time.Year
import java.util.*
import kotlin.concurrent.schedule

class MovieSearchFragment : Fragment(), MoviesAdapter.ItemOnClickListener {

    private lateinit var binding: FragmentMovieSearchBinding
    private val viewModel: MovieSearchViewModel by lazy { ViewModelProvider(this@MovieSearchFragment)[MovieSearchViewModel::class.java] }
    private var adapter = MoviesAdapter(this)
    private var queryParam = ""
    private var timer = Timer()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMovieSearchBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resultList.adapter = adapter

        if (queryParam.isEmpty()) {
            queryParam = Year.now().toString()
            viewModel.getMoviesBySearch(queryParam)
        }

        binding.edtSearchBar.doAfterTextChanged { text ->
            queryParam = text.toString()
            timer.cancel()

            if (queryParam.isEmpty()) {
                    queryParam = Year.now().toString()
                    viewModel.getMoviesBySearch(queryParam)
            } else {
                if (queryParam.length > 2) {
                    timer = Timer()
                        timer.schedule(3000) {
                        viewModel.getMoviesBySearch(queryParam)
                    }
                }
            }
        }

        viewModel.movieResultList.observe(viewLifecycleOwner) {
            when (it) {
                is Result.IsLoading -> {
                    binding.resultList.visibility = View.INVISIBLE
                    binding.loadingBar.visibility = View.VISIBLE
                }

                is Result.Success -> {
                    binding.resultList.visibility = View.VISIBLE
                    binding.loadingBar.visibility = View.INVISIBLE
                    adapter.update(it.value)
                }

                is Result.Failure -> Toast
                    .makeText(
                        this.context,
                        requireContext().getString(R.string.error_message_toast),
                        Toast.LENGTH_SHORT
                    ).show()
            }
        }
    }


    override fun onItemClick(id: Int) = Navigation
        .findNavController(requireView())
        .navigate(MovieSearchFragmentDirections.actionMovieSearchFragmentToMovieDetailFragment(id))
}

