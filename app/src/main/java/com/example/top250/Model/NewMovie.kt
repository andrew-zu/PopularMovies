package com.example.top250.Model


import android.os.Parcel
import android.os.Parcelable

class NewMovie(
    val popularity: Double?,
    val vote_count: Int?,
    val video: Boolean?,
    val poster_path: String?,
    val id: Int?,
    val adult: Boolean?,
    val backdrop_path: String?,
    val original_language: String?,
    val original_title: String?
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
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(popularity)
        parcel.writeValue(vote_count)
        parcel.writeValue(video)
        parcel.writeString(poster_path)
        parcel.writeValue(id)
        parcel.writeValue(adult)
        parcel.writeString(backdrop_path)
        parcel.writeString(original_language)
        parcel.writeString(original_title)
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
        return "$original_title $poster_path $id"
    }
}




