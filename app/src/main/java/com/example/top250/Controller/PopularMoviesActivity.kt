package com.example.top250.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.top250.R
import kotlinx.android.synthetic.main.activity_popular_movies.*

class PopularMoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movies)

        val getMovies = GetMoviesJSON()
        getMovies.execute("https://raw.githubusercontent.com/andrew-zu/data/master/data.json")

    }

}
