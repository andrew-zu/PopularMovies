package com.example.top250.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.top250.Model.NewMovie
import com.example.top250.R
import com.example.top250.Utils.EXTRA_MOVIE
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val movie: NewMovie? = intent.getParcelableExtra(EXTRA_MOVIE)

        movie_title.text = movie?.title
        movie_average.text = movie?.voteAverage.toString()
        movie_release_date.text = movie?.releaseDate
        movie_overview.text = movie?.overview
    }
}
