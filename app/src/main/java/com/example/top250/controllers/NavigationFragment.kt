package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.top250.R
import kotlinx.android.synthetic.main.fragment_navigation.*


class NavigationFragment : Fragment() {

    lateinit var popularMoviesFragment: PopularMoviesFragment
    lateinit var newestMoviesFragment: NewestMoviesFragment
    lateinit var moviesToWatchFragment: MoviesToWatchFragment
    lateinit var watchedMoviesFragment: WatchedMoviesFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        popularMoviesFragment = PopularMoviesFragment()
        moviesToWatchFragment = MoviesToWatchFragment()
        watchedMoviesFragment = WatchedMoviesFragment()
        newestMoviesFragment = NewestMoviesFragment()

        popular_movies_btn.setOnClickListener{
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main_container, popularMoviesFragment)
                ?.addToBackStack("Back to main")
                ?.commit()
        }

        newest_movies_btn.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main_container, newestMoviesFragment)
                ?.addToBackStack("Back to main")
                ?.commit()
        }

        watch_later_btn.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main_container, moviesToWatchFragment)
                ?.addToBackStack("Back to main")
                ?.commit()
        }

        watched_btn.setOnClickListener {
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
