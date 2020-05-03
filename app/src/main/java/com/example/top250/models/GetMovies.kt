package com.example.top250.models

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.top250.R
import com.example.top250.adapters.MoviesAdapter
import com.example.top250.services.DataPopularMovies.popularMovies
import com.example.top250.services.DataWatchedMovies.watchedMovies
import com.example.top250.utils.EXTRA_MOVIE
import com.example.top250.utils.parseJSON
import kotlinx.android.synthetic.main.fragment_all_movies.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.net.URL

suspend fun getMoviesFromJSON(url: String): String = withContext(IO) {
    var result = URL(url).readText()
    return@withContext result
}

fun setMoviesToView(
    url: String,
    context: Context?,
    newFragment: Fragment,
    recyclerView: RecyclerView,
    fragmentManager: FragmentManager?
) {
    CoroutineScope(Main).launch {
        val movies = parseJSON(getMoviesFromJSON(url))
        popularMovies = movies

        val adapter = MoviesAdapter(context, popularMovies) { Movie ->
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
}



