package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.top250.R
import kotlinx.android.synthetic.main.fragment_navigation.*


class NavigationFragment : Fragment() {

    lateinit var allMoviesFragment: AllMoviesFragment
    lateinit var moviesToWatchFragment: MoviesToWatchFragment
    lateinit var watchedMoviesFragment: WatchedMoviesFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        allMoviesFragment = AllMoviesFragment()
        moviesToWatchFragment = MoviesToWatchFragment()
        watchedMoviesFragment = WatchedMoviesFragment()

        top_movies_btn.setOnClickListener{
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main_container, allMoviesFragment)
                ?.addToBackStack("Back to main")
                ?.commit()
        }

        movies_to_watch_btn.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main_container, moviesToWatchFragment)
                ?.addToBackStack("Back to main")
                ?.commit()
        }

        watched_movies_btn.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main_container, watchedMoviesFragment)
                ?.addToBackStack("Back to main")
                ?.commit()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }
}
