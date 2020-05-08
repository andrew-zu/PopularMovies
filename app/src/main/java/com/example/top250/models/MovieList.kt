package com.example.top250.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieList(
    @Expose
    @SerializedName("results")
    val results: ArrayList<Movie>? = null
) {
    override fun toString(): String {
        return "Results($results)"
    }
}