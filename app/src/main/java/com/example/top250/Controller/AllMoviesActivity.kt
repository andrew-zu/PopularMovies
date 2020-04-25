package com.example.top250.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.top250.Adapter.MoviesAdapter
import com.example.top250.R
import com.example.top250.Services.DataPopularMovies
import com.example.top250.Utils.EXTRA_MOVIE
import kotlinx.android.synthetic.main.activity_all_movies.*

class AllMoviesActivity : AppCompatActivity() {

    lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_movies)
        
        val getMovies = GetMoviesJSON()
        getMovies.execute("https://raw.githubusercontent.com/andrew-zu/data/master/data.json")

        adapter = MoviesAdapter(this, DataPopularMovies.popularMovies) { movie ->
            val movieDetailsIntent = Intent(this, MovieDetailsActivity::class.java)
            movieDetailsIntent.putExtra(EXTRA_MOVIE, movie)
            startActivity(movieDetailsIntent)
        }
        moviesListView.adapter = adapter

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        moviesListView.layoutManager = layoutManager


    }
}
