package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.top250.models.NewMovie

import com.example.top250.R
import com.example.top250.services.DataWatchedMovies.watchedMovies
import com.example.top250.utils.EXTRA_MOVIE
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_details.*


class MovieDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle: Bundle? = this.arguments
        val movie: NewMovie? = bundle?.getParcelable(EXTRA_MOVIE)

        val IN_WATCHED_LIST = "REMOVE FROM WATCHED"


        Picasso.get().load(movie?.backdropPath).into(movie_back_image)
        movie_title.text = "${movie?.title}  (${movie?.releaseDate})  *${movie?.voteAverage}"
        movie_overview.text = movie?.overview

        println(watchedMovies)
        println (watchedMovies.contains(movie))


        add_to_watched_btn.setOnClickListener {

            if (movie != null) {
                if(!watchedMovies.contains(movie)){
                    watchedMovies.add(movie)
//                    add_to_watched_btn.text = IN_WATCHED_LIST

                } else {
                    println("Movie is already added!!!")
                }

            } else{
                println("Movie is null!!!!")
            }

            println(watchedMovies)
            println (watchedMovies.contains(movie))

        }
    }



}
