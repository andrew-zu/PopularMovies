package com.example.top250.Controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.top250.Model.getMoviesFromUrl
import com.example.top250.Model.setMovies

import com.example.top250.R
import com.example.top250.Services.DataPopularMovies.popularMovies
import kotlinx.android.synthetic.main.fragment_navigation.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class NavigationFragment : Fragment() {

    lateinit var allMoviesFragment: AllMoviesFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        allMoviesFragment = AllMoviesFragment()

        top_movies_btn.setOnClickListener{
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.main_container, allMoviesFragment)
                ?.addToBackStack("Back to main")
                ?.commit()
        }

        movies_to_watch_btn.setOnClickListener {





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
