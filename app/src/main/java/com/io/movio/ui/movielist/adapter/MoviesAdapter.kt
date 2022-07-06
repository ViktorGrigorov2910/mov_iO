package com.io.movio.ui.movielist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.io.movio.data.enums.Genre
import com.io.movio.databinding.MovieRowBinding
import com.io.movio.data.models.Movie

private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"

class MoviesAdapter(private val listener: ItemOnClickListener) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private val movies = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(MovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.apply {
            binding.tvTitle.text = movies[position].title
            binding.tvGenre.text = getGenreToString(movies[position].genre!!)
            binding.tvReleaseDate.text = movies[position].releaseDate

            Glide.with(this.binding.root)
                .load(BASE_IMAGE_URL.plus(movies[position].imageUrl))
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

    override fun getItemCount(): Int = movies.size

    class MovieViewHolder(val binding: MovieRowBinding) : RecyclerView.ViewHolder(binding.root)

    interface ItemOnClickListener {
        fun onItemClick(id: Int)
    }

}
private fun getGenreToString(genre: List<Int>): String {
    var genres = ""
    for (i in genre) {
        val genreCapital = Genre.getByValue(i).toString()
        val genreString = nameFormatter(genreCapital)
        genres = genres.plus(genreString.plus(", "))
    }
    return genres.dropLast(2)
}

private fun nameFormatter(genreCapital: String): String {
    val genre = genreCapital.lowercase()
    return  genre.replaceFirstChar { first -> first.uppercase() }
}