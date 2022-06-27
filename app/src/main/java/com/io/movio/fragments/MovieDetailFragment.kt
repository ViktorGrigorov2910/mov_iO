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
private const val ARG_TITLE = "title"
private const val ARG_DESCRIPTION = "description"
private const val ARG_CAST = "cast"

class MovieDetailFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailBinding
    private lateinit var title: String
    private lateinit var description: String
    private lateinit var cast: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE).toString()
            description = it.getString(ARG_DESCRIPTION).toString()
            cast = it.getString(ARG_CAST).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)

        binding.tvTitle.text = title
        binding.tvCast.text = cast
        binding.tvDescription.text = description
        binding.tvDescription.movementMethod = ScrollingMovementMethod()

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance(title:String , description:String , cast:String) =
            MovieDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_DESCRIPTION, description)
                    putString(ARG_CAST, cast)
                }
            }
    }

}