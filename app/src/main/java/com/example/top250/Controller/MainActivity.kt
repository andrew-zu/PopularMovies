package com.example.top250.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.top250.R

class MainActivity : AppCompatActivity() {
    lateinit var navigationFragment: NavigationFragment

    override fun onCreate(savedInstanceState: Bundle?) {
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
