package com.io.movio.fragments

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.io.movio.databinding.FragmentMovieDetailBinding

// the fragment initialization parameters
private const val ARG_PARAM1 = "title"
private const val ARG_PARAM2 = "description"
private const val ARG_PARAM3 = "cast"



class MovieDetailFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailBinding

    private var title: String? = null
    private var description: String? = null
    private var cast: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_PARAM1)
            description = it.getString(ARG_PARAM2)
            cast = it.getString(ARG_PARAM3)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

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
        fun newInstance(title: String, description: String , cast:String) =
            MovieDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, title)
                    putString(ARG_PARAM2, description)
                    putString(ARG_PARAM3, cast)
                }
            }
    }

}