package com.example.top250.repository

import com.example.top250.api.MyRetrofitBuilder
import com.example.top250.models.Data.newestMovies
import com.example.top250.models.Data.popularMovies
import com.example.top250.models.Movie
import com.example.top250.utils.API_KEY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpRetryException


object Repository {

    fun getPopularMoviesList(func: () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = MyRetrofitBuilder.apiService.getPopularMovies(API_KEY)
            withContext(Main) {
                try {
                    if (response.isSuccessful) {
                        val list = response.body()?.results
                        if(list!=null){
                            popularMovies = list
                        }
                        else{
                            println("List is empty")
                        }
                        func()
                    } else {
                        println("Error: ${response.code()}")
                    }
                } catch (e: HttpRetryException) {
                    println("Exception ${e.message}")
                } catch (e: Throwable) {
                    println("Ooops: Something else went wrong")
                }
            }
        }
    }

    fun getNewestMoviesList(func: () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = MyRetrofitBuilder.apiService.getLatestMovies(API_KEY)
            withContext(Main) {
                try {
                    if (response.isSuccessful) {
                        val list = response.body()?.results
                        if(list!=null){
                            newestMovies = list
                        }
                        else{
                            println("List is empty")
                        }
                        func()
                    } else {
                        println("Error: ${response.code()}")
                    }
                } catch (e: HttpRetryException) {
                    println("Exception ${e.message}")
                } catch (e: Throwable) {
                    println("Ooops: Something else went wrong")
                }
            }
        }
    }

}
