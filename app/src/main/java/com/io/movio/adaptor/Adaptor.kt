package com.io.movio.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.io.movio.databinding.MovieRowBinding
import com.io.movio.models.Movie

class Adaptor(private val movies: Array<Movie>, private val listener: ItemOnClickListener) :
    RecyclerView.Adapter<Adaptor.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = MovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvTitle.text = movies[position].title
        holder.tvGenre.text = movies[position].genre
        holder.tvReleaseDate.text = movies[position].releaseDate

        holder.itemView.setOnClickListener {
            listener.onItemClick(movies[position])
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }


    class MyViewHolder(binding: MovieRowBinding) : RecyclerView.ViewHolder(binding.root) {
        //Information per row in the list (RecyclerView)
        val tvTitle: TextView = binding.tvTitle
        val tvGenre: TextView = binding.tvGenre
        val tvReleaseDate: TextView = binding.tvReleaseDate

    }

    interface ItemOnClickListener {
        fun onItemClick(movie: Movie)
    }


}