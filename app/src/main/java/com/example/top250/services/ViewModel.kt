package com.example.top250.services

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.top250.R
import com.example.top250.adapters.MoviesAdapter
import com.example.top250.models.Movie
import com.example.top250.utils.EXTRA_MOVIE


fun setMoviesToView(
    movieList: ArrayList<Movie>,
    context: Context?,
    newFragment: Fragment,
    recyclerView: RecyclerView,
    fragmentManager: FragmentManager?
) {

    val adapter = MoviesAdapter(context, movieList) { Movie ->
        val bundle: Bundle? = Bundle()
        bundle?.putParcelable(EXTRA_MOVIE, Movie)
        newFragment.arguments = bundle

        //TODO Find fragment manager from activity, not from a parameter!!!!!!!
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.main_container, newFragment)
            ?.addToBackStack("Back to main")
            ?.commit()
    }
    recyclerView.adapter = adapter

    var spanCount = 2
    val orientation = context?.resources?.configuration?.orientation
    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        spanCount = 3
    }

    val layoutManager = GridLayoutManager(newFragment.activity, spanCount)
    recyclerView.layoutManager = layoutManager
}
