package com.example.top250.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie(
    @Expose
    @SerializedName("popularity")
    val popularity: Double? = null,

    @Expose
    @SerializedName("vote_count")
    val voteCount: Int? = null,

    @Expose
    @SerializedName("video")
    val video: Boolean? = null,

    @Expose
    @SerializedName("poster_path")
    val posterPath: String? = null,

    @Expose
    @SerializedName("id")
    val id: Int? = null,

    @Expose
    @SerializedName("adult")
    val adult: Boolean? = null,

    @Expose
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @Expose
    @SerializedName("original_language")
    val originalLanguage: String? = null,

    @Expose
    @SerializedName("title")
    val title: String? = null,

    @Expose
    @SerializedName("vote_average")
    val voteAverage: Double? = null,

    @Expose
    @SerializedName("overview")
    val overview: String? = null,

    @Expose
    @SerializedName("release_date")
    val releaseDate: String? = null


): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString()
    ) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(popularity)
        parcel.writeValue(voteCount)
        parcel.writeValue(video)
        parcel.writeString(posterPath)
        parcel.writeValue(id)
        parcel.writeValue(adult)
        parcel.writeString(backdropPath)
        parcel.writeString(originalLanguage)
        parcel.writeString(title)
        parcel.writeValue(voteAverage)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "$title $id"
    }
}




