package com.example.top250.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.top250.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        all_movies_btn.setOnClickListener {
            val allMoviesIntent = Intent(this, AllMoviesActivity::class.java)
            startActivity(allMoviesIntent)
        }

        movies_to_watch_btn.setOnClickListener {
            val popularMoviesIntent = Intent(this, PopularMoviesActivity::class.java)
            startActivity(popularMoviesIntent)
        }
    }
}
