package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.top250.R
import com.example.top250.models.getPopularMoviesList
import com.example.top250.models.setMoviesToView
import com.example.top250.services.Data.popularMovies
import kotlinx.android.synthetic.main.fragment_all_movies.*


class AllMoviesFragment : Fragment() {

    lateinit var movieDetailsFragment: MovieDetailsFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDetailsFragment = MovieDetailsFragment()

        val jsonUrl = "https://raw.githubusercontent.com/andrew-zu/data/master/data.json"

        val fragmentManager = activity?.supportFragmentManager

        getPopularMoviesList(jsonUrl){
            setMoviesToView(popularMovies, context, movieDetailsFragment, top_movies_recycler_view, fragmentManager)
        }
    }



}
