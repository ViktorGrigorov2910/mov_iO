package com.io.movio.ui.moviesearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.io.movio.R
import com.io.movio.databinding.FragmentMovieSearchBinding
import com.io.movio.domain.Result
import com.io.movio.ui.adapter.MoviesAdapter

class MovieSearchFragment : Fragment(), MoviesAdapter.ItemOnClickListener {

    private lateinit var binding: FragmentMovieSearchBinding
    private val viewModel: MovieSearchViewModel by lazy { ViewModelProvider(this@MovieSearchFragment)[MovieSearchViewModel::class.java] }
    private var adapter = MoviesAdapter(this)

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
        var queryParam = "2022"
        binding.resultList.adapter = adapter
        viewModel.getMoviesBySearch(queryParam)

        binding.edtSearchBar.doAfterTextChanged { text ->
            queryParam = text.toString()
            //TODO: Fire a new request ONLY if by 3 seconds no new chars are written and show the results
            if(queryParam.isEmpty()) queryParam = "2022"
            if(queryParam.length > 3 )  viewModel.getMoviesBySearch(queryParam)
        }

        viewModel.movieResultList.observe(viewLifecycleOwner) {
            when (it) {
                is Result.Success -> adapter.update(it.value)
                is Result.Failure -> Toast.makeText(
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

