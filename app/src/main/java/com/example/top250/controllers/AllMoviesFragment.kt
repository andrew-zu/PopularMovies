package com.example.top250.controllers

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.top250.adapters.MoviesAdapter

import com.example.top250.R
import com.example.top250.models.getMoviesFromJSON
import com.example.top250.services.DataPopularMovies
import com.example.top250.services.DataPopularMovies.popularMovies
import com.example.top250.utils.EXTRA_MOVIE
import com.example.top250.utils.parseJSON
import kotlinx.android.synthetic.main.fragment_all_movies.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main


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

//        setMovies("https://raw.githubusercontent.com/andrew-zu/data/master/data.json")


        CoroutineScope(Main).launch {
            println("Start downloading")

            val movies =
                parseJSON(getMoviesFromJSON("https://raw.githubusercontent.com/andrew-zu/data/master/data.json"))
            popularMovies = movies

            adapter = MoviesAdapter(context, DataPopularMovies.popularMovies) { Movie ->

                movieDetailsFragment = MovieDetailsFragment()
                val bundle: Bundle? = Bundle()
                bundle?.putParcelable(EXTRA_MOVIE, Movie)
                movieDetailsFragment.arguments = bundle
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.main_container, movieDetailsFragment)
                    ?.addToBackStack("Back to main")
                    ?.commit()
            }

            topMoviesRecyclerView.adapter = adapter

            var spanCount = 2
            val orientation = resources.configuration.orientation
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                spanCount = 3
            }

            val layoutManager = GridLayoutManager(activity, spanCount)
            topMoviesRecyclerView.layoutManager = layoutManager
        }

    }

}
