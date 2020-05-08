package com.example.top250.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.top250.models.Movie
import com.example.top250.R
import com.squareup.picasso.Picasso

class MoviesAdapter(
    val context: Context?,
    val movies: ArrayList<Movie>,
    val itemClick: (Movie) -> Unit
) :
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

    inner class MoviesHolder(itemView: View, val itemClick: (Movie) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        val movieImage = itemView.findViewById<ImageView>(R.id.movie_image)
        val title = itemView.findViewById<TextView>(R.id.title)

        fun bindMovie(movie: Movie, context: Context?) {
            Picasso.get().load("https://image.tmdb.org/t/p/original" + movie.posterPath)
                .into(movieImage)
            title.text = movie.title
            itemView.setOnClickListener { itemClick(movie) }
        }
    }
}
