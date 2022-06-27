package com.io.movio.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
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
            holder.tvTitle.text = movies[position].title
            holder.tvGenre.text = movies[position].genre
            holder.tvReleaseDate.text = movies[position].releaseDate

            holder.itemView.setOnClickListener {
                listener.onItemClick(movies[position])
            }
        }
    }

    override fun getItemCount(): Int  =  movies.size

    class MovieViewHolder(binding: MovieRowBinding) : RecyclerView.ViewHolder(binding.root) {
        //Information per row in the list (RecyclerView)
        val tvTitle: TextView = binding.tvTitle
        val tvGenre: TextView = binding.tvGenre
        val tvReleaseDate: TextView = binding.tvReleaseDate
    }

    interface ItemOnClickListener {
        fun onItemClick(movie: Movie)
    }

}