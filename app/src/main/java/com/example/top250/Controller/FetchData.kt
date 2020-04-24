package com.example.top250.Controller

import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.lang.Exception
import java.net.MalformedURLException
import java.net.URL


class FetchData : AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg params: String?): String {
        if (params[0] == null) {
            return "No URL specified"
        }
        try {
            return URL(params[0]).readText()
        } catch (e: Exception) {
            val errorMessage = when (e) {
                is MalformedURLException -> {
                    "doInBackground: Invalid URL ${e.message}"
                }
                is IOException -> {
                    "doInBackground: IO Exception reading data: ${e.message}"
                }
                is SecurityException -> {
                    "doInBackground: Security exception: Needs permission? ${e.message}"
                }
                else -> {
                    "Unknown error: ${e.message}"
                }
            }
            return errorMessage
        }
    }

    override fun onPostExecute(result: String?) {
        println(result)
    }
}