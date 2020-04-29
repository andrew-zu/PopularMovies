package com.example.top250.Controller

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.top250.Adapter.MoviesAdapter
import com.example.top250.Model.GetMoviesJSON

import com.example.top250.R
import com.example.top250.Services.DataPopularMovies
import com.example.top250.Utils.EXTRA_MOVIE
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

        //get data
        val getMovies = GetMoviesJSON()
        getMovies.execute("https://raw.githubusercontent.com/andrew-zu/data/master/data.json")


        adapter = MoviesAdapter(context, DataPopularMovies.popularMovies) {Movie ->
            println("clicking on Movie")
            //onClick
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
