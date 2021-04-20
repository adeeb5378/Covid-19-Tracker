package com.example.covid_19tracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryWise.setOnClickListener {
            val intent = Intent(this,WorldWiseActivity::class.java)
            Toast.makeText(this, "World Wise Cases", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        stateWise.setOnClickListener {
            val intent = Intent(this,stateWise_Activity::class.java)
            Toast.makeText(this, "State Wise Cases", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }
}