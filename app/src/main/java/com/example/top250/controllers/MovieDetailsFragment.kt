package com.example.top250.controllers

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.top250.models.Movie
import com.example.top250.R
import com.example.top250.models.Data.moviesToWatch
import com.example.top250.models.Data.watchedMovies
import com.example.top250.services.MySharedPreferences
import com.example.top250.utils.EXTRA_MOVIE
import com.example.top250.utils.MOVIES_TO_WATCH
import com.example.top250.utils.WATCHED_MOVIES
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_details.*

private const val REMOVE_FROM_WATCHED = "REMOVE FROM WATCHED"
private const val ADD_TO_WATCHED = "ADD TO WATCHED"
private const val REMOVE_FROM_WATCH_LATER = "REMOVE FROM WATCH LATER"
private const val ADD_TO_WATCH_LATER = "ADD TO WATCH LATER"
private const val TAG = "MovieDetailsFragment"

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

        //watched movies
        if (watchedMovies.contains(movie)) {
            add_remove_to_watched_btn.text = REMOVE_FROM_WATCHED
        } else {
            add_remove_to_watched_btn.text = ADD_TO_WATCHED
        }

        //watch later
        if (moviesToWatch.contains(movie)) {
            add_remove_to_watchlist_btn.text = REMOVE_FROM_WATCH_LATER
        } else {
            add_remove_to_watchlist_btn.text = ADD_TO_WATCH_LATER
        }

        add_remove_to_watched_btn.setOnClickListener {
            if (watchedMovies.contains(movie)) {
                removeFromWatched(movie)
                add_remove_to_watched_btn.text = ADD_TO_WATCHED
            } else {
                addToWatched(movie)
                add_remove_to_watched_btn.text = REMOVE_FROM_WATCHED
            }
        }

        add_remove_to_watchlist_btn.setOnClickListener {
            if (moviesToWatch.contains(movie)) {
                removeFromWatchLater(movie)
                add_remove_to_watchlist_btn.text = ADD_TO_WATCH_LATER
            } else {
                addToWatchLater(movie)
                add_remove_to_watchlist_btn.text = REMOVE_FROM_WATCH_LATER
            }
        }
    }

    fun addToWatched(movie: Movie?) {
        if (movie != null) {
            if (!watchedMovies.contains(movie)) {
                watchedMovies.add(movie)
                MySharedPreferences.saveToPref(watchedMovies, WATCHED_MOVIES)
                Log.d(TAG, "Movie $movie added to watchedMovies")
            } else {
                Log.d(TAG, "Movie is already added!")
            }

        } else {
            Log.d(TAG, "Movie is null!")
        }
    }

    fun removeFromWatched(movie: Movie?) {
        if (movie != null) {
            if (watchedMovies.contains(movie)) {
                watchedMovies.remove(movie)
                MySharedPreferences.saveToPref(watchedMovies, WATCHED_MOVIES)
            } else {
                Log.d(TAG, "Movie not in a list")
            }

        } else {
            Log.d(TAG, "Movie is null!")
        }
        Log.d(TAG, "Movie $movie removed")
    }

    fun addToWatchLater(movie: Movie?) {
        if (movie != null) {
            if (!moviesToWatch.contains(movie)) {
                moviesToWatch.add(movie)
                MySharedPreferences.saveToPref(moviesToWatch, MOVIES_TO_WATCH)
                Log.d(TAG, "Movie $movie added to watchedMovies")
            } else {
                Log.d(TAG, "Movie is already added!")
            }

        } else {
            Log.d(TAG, "Movie is null!")
        }
    }

    fun removeFromWatchLater(movie: Movie?) {
        if (movie != null) {
            if (moviesToWatch.contains(movie)) {
                moviesToWatch.remove(movie)
                MySharedPreferences.saveToPref(moviesToWatch, MOVIES_TO_WATCH)
            } else {
                Log.d(TAG, "Movie not in a list")
            }

        } else {
            Log.d(TAG, "Movie is null!")
        }
        Log.d(TAG, "Movie $movie removed")
    }


}
