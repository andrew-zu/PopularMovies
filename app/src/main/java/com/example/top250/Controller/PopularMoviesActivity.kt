package com.example.top250.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.top250.Model.NewMovie
import com.example.top250.R

class PopularMoviesActivity : AppCompatActivity() {
    lateinit var adapter: ArrayAdapter<NewMovie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movies)

    }

}
