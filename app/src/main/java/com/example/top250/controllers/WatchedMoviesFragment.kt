package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.example.top250.R
import com.example.top250.models.setMoviesToView
import com.example.top250.services.Data.watchedMovies
import com.example.top250.services.MySharedPreferences
import com.example.top250.utils.WATCHED_MOVIES
import kotlinx.android.synthetic.main.fragment_watched_movies.*


class WatchedMoviesFragment : Fragment() {

    lateinit var movieDetailsFragment: MovieDetailsFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            watchedMovies = MySharedPreferences.retrieveFromPref(WATCHED_MOVIES)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_watched_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDetailsFragment = MovieDetailsFragment()

        if(watchedMovies.isEmpty()){
            no_movies_to_display.visibility = VISIBLE
        }

        val fragmentManager = activity?.supportFragmentManager

        setMoviesToView(watchedMovies, context, movieDetailsFragment, movies_to_watch_recycler_view, fragmentManager)
    }
}
