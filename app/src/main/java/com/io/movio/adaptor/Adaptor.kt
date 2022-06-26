package com.io.movio.adaptor

import android.content.pm.ModuleInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.io.movio.R
import com.io.movio.models.MovieDTO

class Adaptor(private val movies: Array<MovieDTO>, private val listener: ItemOnClickListener) :
    RecyclerView.Adapter<Adaptor.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptor.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adaptor.MyViewHolder, position: Int) {
        holder.tvTitle.text = movies[position].title

        holder.itemView.setOnClickListener(View.OnClickListener {
            listener.onItemClick(movies[position])
        })

    }

    override fun getItemCount(): Int {
        return movies.size
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //Information per row in the list (RecyclerView)
        val tvTitle: TextView = view.findViewById(R.id.tv_title)


    }

    interface ItemOnClickListener {
        fun onItemClick(movieDTO: MovieDTO)
    }


}