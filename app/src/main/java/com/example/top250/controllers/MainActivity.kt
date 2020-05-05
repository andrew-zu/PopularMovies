package com.example.top250.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.top250.R
import com.example.top250.services.MySharedPreferences

class MainActivity : AppCompatActivity() {
    lateinit var navigationFragment: NavigationFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        MySharedPreferences.with(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //show nav fragment
        navigationFragment = NavigationFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, navigationFragment)
            .commit()
    }
}
