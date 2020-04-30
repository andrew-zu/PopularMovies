package com.example.top250.controllers

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.top250.adapters.MoviesAdapter
import com.example.top250.models.setMovies

import com.example.top250.R
import com.example.top250.services.DataPopularMovies
import com.example.top250.utils.EXTRA_MOVIE
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


//        val getMovies = GetMoviesJSON()
//        getMovies.execute("https://raw.githubusercontent.com/andrew-zu/data/master/data.json")

        setMovies("https://raw.githubusercontent.com/andrew-zu/data/master/data.json")

        adapter = MoviesAdapter(context, DataPopularMovies.popularMovies) {Movie ->
            println("clicking on Movie")

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
