package com.io.movio.ui.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.io.movio.databinding.MovieRowBinding
import com.io.movio.data.models.Movie

class MoviesAdapter(private val listener: ItemOnClickListener)
    : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private val movies = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder
    = MovieViewHolder(MovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.apply {
            binding.tvTitle.text = movies[position].title
            binding.tvGenre.text = movies[position].genre
            binding.tvReleaseDate.text = movies[position].releaseDate

            Glide.with(this.binding.root)
                .load(movies[position].image_url)
                .into(binding.imageView)

            itemView.setOnClickListener {
                listener.onItemClick(movies[position].id)
            }
        }
    }

    fun update(newMovies: List<Movie>) {
        movies.clear()
        movies.addAll(newMovies)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int  =  movies.size

    class MovieViewHolder(val binding: MovieRowBinding) : RecyclerView.ViewHolder(binding.root)

    interface ItemOnClickListener {
        fun onItemClick(id: Int)
    }

}