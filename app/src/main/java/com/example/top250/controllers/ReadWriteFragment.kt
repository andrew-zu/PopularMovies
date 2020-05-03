package com.example.top250.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager

import com.example.top250.R
import kotlinx.android.synthetic.main.fragment_read_write.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.File


class ReadWriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_read_write, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        read_from_file.text = readFromFile()


        write_btn.setOnClickListener {
            writeToFile(text_to_write.text.toString())
            text_to_write.text.clear()
        }

        read_btn.setOnClickListener {
            read_from_file.text = readFromFile()
        }

        clear_btn.setOnClickListener {
            clearFile()
            read_from_file.text = readFromFile()
        }
    }




    fun writeToFile(text:String) {

        var myDataObject = JSONObject()
        var array = JSONArray()

        array.put(text)
        myDataObject.put("Movies List", array)

        val fileName = "data.json"
        val fileObject = File(context?.filesDir, fileName)
        if (!fileObject.exists()) {
            fileObject.createNewFile()
            println("File Created")
        }
        fileObject.appendText(myDataObject.toString())
    }

    fun readFromFile(): String {
        val fileName = "data.json"
        val fileObject = File(context?.filesDir, fileName)
        return fileObject.readText()
    }

    fun clearFile() {
        val fileName = "data.json"
        val fileObject = File(context?.filesDir, fileName)
        fileObject.writeText("")
    }

}
