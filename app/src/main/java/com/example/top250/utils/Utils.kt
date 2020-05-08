package com.example.top250.utils

import com.example.top250.models.Movie
import org.json.JSONArray
import org.json.JSONException

fun jsonToArrayList(jsonString: String?): ArrayList<Movie> {
    val movieList = ArrayList<Movie>()
    try {
        val moviesArray = JSONArray(jsonString)
        for (i in 0 until moviesArray.length()) {
            val jsonMovie = moviesArray.getJSONObject(i)
            val popularity = jsonMovie.getDouble("popularity")
            val voteCount: Int? = jsonMovie.getInt("vote_count")
            val video: Boolean? = jsonMovie.getBoolean("video")
            val posterPath: String? = jsonMovie.getString("poster_path")
            val id: Int? = jsonMovie.getInt("id")
            val adult: Boolean? = jsonMovie.getBoolean("adult")
            val backdropPath: String? = jsonMovie.getString("backdrop_path")
            val originalLanguage: String? = jsonMovie.getString("original_language")
            val title: String? = jsonMovie.getString("title")
            val voteAverage: Double? = jsonMovie.getDouble("vote_average")
            val overview: String? = jsonMovie.getString("overview")
            var releaseDate: String? = jsonMovie.getString("release_date")

            val movieObject = Movie(
                popularity,
                voteCount,
                video,
                posterPath,
                id,
                adult,
                backdropPath,
                originalLanguage,
                title,
                voteAverage,
                overview,
                releaseDate
            )
            movieList.add(movieObject)
        }
    } catch (e: JSONException) {
        e.printStackTrace()
    }
    return movieList
}
