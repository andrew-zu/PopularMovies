package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.top250.R
import com.example.top250.models.Data.popularMovies
import com.example.top250.repository.Repository.getPopularMoviesList
import com.example.top250.services.setMoviesToView
import kotlinx.android.synthetic.main.fragment_popular_movies.*


class PopularMoviesFragment : Fragment() {

    lateinit var movieDetailsFragment: MovieDetailsFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDetailsFragment = MovieDetailsFragment()

        val fragmentManager = activity?.supportFragmentManager

        getPopularMoviesList {
            setMoviesToView(
                popularMovies,
                context,
                movieDetailsFragment,
                popular_movies_recycler_view,
                fragmentManager
            )
        }
    }

}
