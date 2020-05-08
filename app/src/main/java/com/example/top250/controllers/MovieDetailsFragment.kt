package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.top250.models.Movie
import com.example.top250.R
import com.example.top250.models.Data.watchedMovies
import com.example.top250.services.MySharedPreferences
import com.example.top250.utils.EXTRA_MOVIE
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_details.*

val REMOVE_FROM_WATCHED = "REMOVE FROM WATCHED"
val ADD_TO_WATCHED = "ADD TO WATCHED"

class MovieDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle: Bundle? = this.arguments
        val movie: Movie? = bundle?.getParcelable(EXTRA_MOVIE)

        Picasso.get().load("https://image.tmdb.org/t/p/original" + movie?.backdropPath)
            .into(movie_back_image)
        movie_title.text = movie?.title
        movie_release_year.text = "(${movie?.releaseDate?.subSequence(0,4)})"
        movie_overview.text = movie?.overview
        movie_rating.text = "${movie?.voteAverage}/10"


        if (containsMovie(movie)) {
            add_to_watched_btn.text = REMOVE_FROM_WATCHED
        } else {
            add_to_watched_btn.text = ADD_TO_WATCHED
        }

        add_to_watched_btn.setOnClickListener {
            if (containsMovie(movie)) {
                println("movie removed ${movie?.title}")
                removeFromWatched(movie)
                add_to_watched_btn.text = ADD_TO_WATCHED
            } else {
                println("Movie aded ${movie?.title}")
                addToWatched(movie)
                add_to_watched_btn.text = REMOVE_FROM_WATCHED
            }
        }

        add_to_watchlist_btn.setOnClickListener {
            val toast = Toast.makeText(context, "Not yet implemented", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    fun addToWatched(movie: Movie?) {
        if (movie != null) {
            if (!containsMovie(movie)) {
                watchedMovies.add(movie)
                MySharedPreferences.saveToPref(watchedMovies)
            } else {
                println("Movie is already added!!!")
            }

        } else {
            println("Movie is null!!!!")
        }
    }

    fun removeFromWatched(movie: Movie?) {
        if (movie != null) {
            if (containsMovie(movie)) {
                removeMovieWithId(movie)
                MySharedPreferences.saveToPref(watchedMovies)
            } else {
                println("Movie not in a list")
            }

        } else {
            println("Movie is null!!!!")
        }
    }


    fun containsMovie(movie: Movie?): Boolean {
        val currentId = movie?.id
        watchedMovies.forEach {
            if (it.id == currentId) {
                return true
            }
        }
        return false
    }

    fun removeMovieWithId(movie: Movie?) {
        val currentId = movie?.id
        watchedMovies.forEach {
            if (it.id == currentId) {
                watchedMovies.remove(it)
            }
        }
    }
}
