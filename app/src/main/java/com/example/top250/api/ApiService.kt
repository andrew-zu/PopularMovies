package com.example.top250.api

import com.example.top250.models.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") key: String
    ): Response<MovieList>

    @GET("movie/now_playing")
    suspend fun getLatestMovies(
        @Query("api_key") key: String
    ): Response<MovieList>

}
