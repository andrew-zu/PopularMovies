package com.example.top250.services

import android.content.Context
import android.content.SharedPreferences
import com.example.top250.models.Movie
import com.example.top250.utils.WATCHED_MOVIES
import com.example.top250.utils.jsonToArrayList
import com.google.gson.Gson

object MySharedPreferences {

    //Shared Preference field used to save and retrieve JSON string
    lateinit var preferences: SharedPreferences

    //Name of Shared Preference file
    private const val PREFERENCES_FILE_NAME = "PREFERENCES_FILE_NAME"

    /**
     * Call this first before retrieving or saving object.
     *
     * @param application Instance of application class
     */
    fun with(context: Context) {
        preferences = context.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun saveToPref(list: ArrayList<Movie>) {
        clearSharedPreference()
        val editor: SharedPreferences.Editor = preferences.edit()
        val dataString = Gson().toJson(list)
        editor.putString(WATCHED_MOVIES, dataString)
        editor.commit()
    }

    fun retrieveFromPref(KEY_NAME: String): ArrayList<Movie> {
        var retrievedMovieList = ArrayList<Movie>()
        val dataString = preferences.getString(KEY_NAME, null)
        if(dataString!=null){
            retrievedMovieList = jsonToArrayList(dataString)
            return retrievedMovieList
        } else {
            return retrievedMovieList
        }
    }

    fun clearSharedPreference() {
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.clear()
        editor.commit()
    }

}