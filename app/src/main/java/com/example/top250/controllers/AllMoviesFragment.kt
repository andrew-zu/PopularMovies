package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.top250.adapters.MoviesAdapter

import com.example.top250.R
import com.example.top250.models.setMoviesToView
import kotlinx.android.synthetic.main.fragment_all_movies.*


class AllMoviesFragment : Fragment() {

    lateinit var adapter: MoviesAdapter
    lateinit var movieDetailsFragment: MovieDetailsFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieDetailsFragment = MovieDetailsFragment()

        val jsonUrl = "https://raw.githubusercontent.com/andrew-zu/data/master/data.json"

        val fragmentManager = activity?.supportFragmentManager
        setMoviesToView(jsonUrl, this.context, movieDetailsFragment, topMoviesRecyclerView, fragmentManager)

    }

}
