package com.example.top250.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.top250.Model.Movie
import com.example.top250.R
import com.example.top250.Utils.EXTRA_MOVIE
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val movie: Movie? = intent.getParcelableExtra(EXTRA_MOVIE)

        movie_rank.text = movie?.rank
        movie_title.text = movie?.title
        movie_year.text = movie?.year
        movie_rating.text = movie?.rating
    }
}
