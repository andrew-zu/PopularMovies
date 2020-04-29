package com.example.top250.Controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.top250.Model.NewMovie

import com.example.top250.R
import com.example.top250.Utils.EXTRA_MOVIE
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val bundle: Bundle? = this.arguments
        val movie: NewMovie? = bundle?.getParcelable(EXTRA_MOVIE)
        println(movie)

        Picasso.get().load(movie?.backdropPath).into(movie_back_image)
        movie_overview.text = movie?.title

    }


}
