package com.example.top250.models

import com.example.top250.services.DataPopularMovies.popularMovies
import com.example.top250.utils.parseJSON
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

suspend fun getMoviesFromUrl(url: String): String = withContext(IO) {
    return@withContext URL(url).readText()
}

fun setMovies(url: String){
    CoroutineScope(Main).launch {
        popularMovies = parseJSON(getMoviesFromUrl(url))
    }
}


