package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.top250.R

class MoviesToWatchFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val toast = Toast.makeText(context, "Not yet implemented", Toast.LENGTH_SHORT)
        toast.show()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_to_watch, container, false)
    }


}
