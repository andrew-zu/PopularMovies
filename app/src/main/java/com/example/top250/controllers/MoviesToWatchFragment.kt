package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.top250.R
import com.example.top250.models.Data.moviesToWatch
import com.example.top250.services.MySharedPreferences
import com.example.top250.services.setMoviesToView
import com.example.top250.utils.MOVIES_TO_WATCH
import kotlinx.android.synthetic.main.fragment_movies_to_watch.*

class MoviesToWatchFragment : Fragment() {

    lateinit var movieDetailsFragment: MovieDetailsFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        moviesToWatch = MySharedPreferences.retrieveFromPref(MOVIES_TO_WATCH)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_to_watch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieDetailsFragment = MovieDetailsFragment()

        if(moviesToWatch.isEmpty()){
            no_movies_to_display1.visibility = View.VISIBLE
        }

        val fragmentManager = activity?.supportFragmentManager

        setMoviesToView(
            moviesToWatch,
            context,
            movieDetailsFragment,
            movies_to_watch_recycler_view,
            fragmentManager
        )
    }


}
