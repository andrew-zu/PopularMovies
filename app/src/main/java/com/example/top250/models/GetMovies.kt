package com.example.top250.models

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.top250.services.DataPopularMovies.popularMovies
import com.example.top250.utils.parseJSON
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

suspend fun getMoviesFromJSON(url: String): String = withContext(IO) {
    var result = URL(url).readText()
    println("Finish downloading")
    return@withContext result
}

fun setMovies(url: String) {
    CoroutineScope(Main).launch {
        val movies = parseJSON(getMoviesFromJSON(url))
        popularMovies = movies

    }
}


