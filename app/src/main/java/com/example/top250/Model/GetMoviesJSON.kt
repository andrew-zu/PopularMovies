package com.example.top250.Model

import android.os.AsyncTask
import com.example.top250.Services.DataPopularMovies.popularMovies
import org.json.JSONException
import org.json.JSONObject
import java.net.URL

class GetMoviesJSON : AsyncTask<String, Void, ArrayList<NewMovie>>() {

    override fun doInBackground(vararg params: String): ArrayList<NewMovie> {

        val movieList = ArrayList<NewMovie>()
        try {
            val jsonData = JSONObject(URL(params[0]).readText())
            val moviesArray = jsonData.getJSONArray("movies")

            for (i in 0 until moviesArray.length()) {
                val jsonMovie = moviesArray.getJSONObject(i)

                val popularity = jsonMovie.getDouble("popularity")
                val voteCount: Int? = jsonMovie.getInt("vote_count")
                val video: Boolean? = jsonMovie.getBoolean("video")
                val posterPath: String? =
                    "https://image.tmdb.org/t/p/original" +
                            jsonMovie.getString("poster_path")

                val id: Int? = jsonMovie.getInt("id")
                val adult: Boolean? = jsonMovie.getBoolean("adult")
                val backdropPath: String? =
                    "https://image.tmdb.org/t/p/original" +
                            jsonMovie.getString("backdrop_path")

                val originalLanguage: String? = jsonMovie.getString("original_language")
                val title: String? = jsonMovie.getString("title")
                val voteAverage: Double? = jsonMovie.getDouble("vote_average")
                val overview: String? = jsonMovie.getString("overview")
                var releaseDate: String? = jsonMovie.getString("release_date")
                releaseDate = releaseDate?.subSequence(0,4) as String?

                val movieObject = NewMovie(
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
            cancel(true)
        }
        return movieList
    }

    override fun onPostExecute(result: ArrayList<NewMovie>) {
        super.onPostExecute(result)
    popularMovies = result
    }
}