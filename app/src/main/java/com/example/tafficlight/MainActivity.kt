package com.example.tafficlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    val stateOfTrafficLight = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startStop() {
        when (stateOfTrafficLight) {
            true -> ""
            false -> ""
        }


    }
}