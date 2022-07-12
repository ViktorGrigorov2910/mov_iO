package com.io.movio.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.io.movio.R
import com.io.movio.common.Constant
import com.io.movio.data.enums.Genre
import com.io.movio.databinding.MovieRowBinding
import com.io.movio.domain.Movie

class MoviesAdapter(private val listener: ItemOnClickListener) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private val movies = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(MovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.apply {
            binding.tvTitle.text = movie.title
            if (movie.genre.isEmpty()) {
                binding.tvGenre.text = "N/A"
            } else {
                binding.tvGenre.text = getGenreToString(movie.genre, binding.root.context)
            }
            binding.tvReleaseDate.text = movie.releaseDate

            if (movie.imageUrl == Constant.IMAGE_NOT_FOUND_URL){
                Glide.with(this.binding.root)
                    .load(R.drawable.ic_default_picture_not_found)
                    .into(binding.imageView)
            }else{
                Glide.with(this.binding.root)
                    .load(movie.imageUrl)
                    .into(binding.imageView)
            }

            itemView.setOnClickListener {
                listener.onItemClick(movie.id)
            }
        }
    }

    fun update(newMovies: List<Movie>) {
        movies.clear()
        movies.addAll(newMovies)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = movies.size

    class MovieViewHolder(val binding: MovieRowBinding) : RecyclerView.ViewHolder(binding.root)

    interface ItemOnClickListener {
        fun onItemClick(id: Int)
    }

}

private fun getGenreToString(movieGenres: List<Int>, context: Context): String {
    return StringBuilder().apply {
        movieGenres.map {
            if (it != movieGenres.lastIndex && it != movieGenres.first()) {
                append(", ")
            }
            append(context.getString(Genre.getByValue(it).genreNameId))
        }
    }.toString()
}

