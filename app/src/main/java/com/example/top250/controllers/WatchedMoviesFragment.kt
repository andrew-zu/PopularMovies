package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.top250.R
import com.example.top250.models.setMoviesToView
import com.example.top250.services.DataWatchedMovies.watchedMovies
import kotlinx.android.synthetic.main.fragment_all_movies.*
import kotlinx.android.synthetic.main.fragment_watched_movies.*


class WatchedMoviesFragment : Fragment() {

    lateinit var movieDetailsFragment: MovieDetailsFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_watched_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDetailsFragment = MovieDetailsFragment()

        val fragmentManager = activity?.supportFragmentManager

        setMoviesToView(watchedMovies, this.context, movieDetailsFragment, watched_movies_recycler_view, fragmentManager)


    }

}
