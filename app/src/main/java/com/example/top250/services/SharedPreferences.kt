package com.example.top250.services

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.top250.models.Movie
import com.example.top250.utils.WATCHED_MOVIES
import com.example.top250.utils.jsonToArrayList
import com.google.gson.Gson

object MySharedPreferences {

    private const val TAG = "SharedPreferences"

    //Shared Preference field used to save and retrieve JSON string
    lateinit var preferences: SharedPreferences

    //Name of Shared Preference file
    private const val PREFERENCES_FILE_NAME = "PREFERENCES_FILE_NAME"

    //call in MainActivity to set context
    fun with(context: Context) {
        preferences = context.getSharedPreferences(PREFERENCES_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun saveToPref(list: ArrayList<Movie>, KEY_NAME: String) {
        clearSharedPreference(KEY_NAME)
        val editor: SharedPreferences.Editor = preferences.edit()
        val dataString = Gson().toJson(list)
        editor.putString(KEY_NAME, dataString)
        editor.apply()
        Log.d(TAG, "Saving to SP")
    }

    fun retrieveFromPref(KEY_NAME: String): ArrayList<Movie> {
        Log.d(TAG, "Retrieving from SP")
        var retrievedMovieList = ArrayList<Movie>()
        val dataString = preferences.getString(KEY_NAME, null)
        if(dataString!=null){
            retrievedMovieList = jsonToArrayList(dataString)
            return retrievedMovieList
        } else {
            return retrievedMovieList
        }
    }

    fun clearSharedPreference(KEY_NAME: String) {
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.remove(KEY_NAME)
        editor.apply()
        Log.d(TAG, "Clearing SP")
    }

}