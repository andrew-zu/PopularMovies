package com.example.top250.Model

import com.example.top250.Services.DataPopularMovies.popularMovies
import com.example.top250.Utils.parceJSON
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
        popularMovies = parceJSON(getMoviesFromUrl(url))
    }
}


