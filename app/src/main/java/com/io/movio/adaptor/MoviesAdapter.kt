package com.io.movio.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.io.movio.databinding.MovieRowBinding
import com.io.movio.models.Movie

class MoviesAdapter(private val movies: Array<Movie>,
                    private val listener: ItemOnClickListener)
    : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder
    = MovieViewHolder(MovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.apply {
            binding.tvTitle.text = movies[position].title
            binding.tvGenre.text = movies[position].genre
            binding.tvReleaseDate.text = movies[position].releaseDate

            itemView.setOnClickListener {
                listener.onItemClick(movies[position])
            }
        }
    }

    override fun getItemCount(): Int  =  movies.size

    class MovieViewHolder(val binding: MovieRowBinding) : RecyclerView.ViewHolder(binding.root)

    interface ItemOnClickListener {
        fun onItemClick(movie: Movie)
    }

}