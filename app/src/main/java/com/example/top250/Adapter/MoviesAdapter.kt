package com.example.top250.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.top250.Model.NewMovie
import com.example.top250.R

class MoviesAdapter(val context: Context, val movies: ArrayList<NewMovie>, val itemClick: (NewMovie) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_item, parent, false)
        return MoviesHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return movies.count()
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        holder.bindMovie(movies[position], context)
    }

    inner class MoviesHolder(itemView: View, val itemClick: (NewMovie) -> Unit) : RecyclerView.ViewHolder(itemView) {

        val movieImage = itemView.findViewById<ImageView>(R.id.movie_image)
        val movieInfo = itemView.findViewById<TextView>(R.id.movie_info)


        fun bindMovie(movie: NewMovie, context: Context) {
            val infoText = movie.title + " - " + movie.releaseDate
            movieInfo.text = infoText
            itemView.setOnClickListener { itemClick(movie) }
        }
    }
}