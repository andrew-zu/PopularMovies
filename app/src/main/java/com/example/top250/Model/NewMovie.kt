package com.example.top250.Model


import android.os.Parcel
import android.os.Parcelable

class NewMovie(
    val popularity: Double?,
    val voteCount: Int?,
    val video: Boolean?,
    val posterPath: String?,
    val id: Int?,
    val adult: Boolean?,
    val backdropPath: String?,
    val origiballanguage: String?,
    val title: String?,
    val voteAverage: Double?,
    val overview: String?,
    val releaseDate: String?


) : Parcelable {
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
        parcel.writeString(origiballanguage)
        parcel.writeString(title)
        parcel.writeValue(voteAverage)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewMovie> {
        override fun createFromParcel(parcel: Parcel): NewMovie {
            return NewMovie(parcel)
        }

        override fun newArray(size: Int): Array<NewMovie?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "$title $posterPath $id"
    }
}




