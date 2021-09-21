package com.example.notbored

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_goTerms = findViewById<Button>(R.id.btn_goTerms)
        val btn_goActivities = findViewById<Button>(R.id.btn_activities)

        btn_goTerms.setOnClickListener {
            val intent : Intent = Intent(this, TermsAndConditions::class.java)
            startActivity(intent)
        }


        btn_goActivities.setOnClickListener {
            val intent : Intent = Intent(this, Activities::class.java)
            startActivity(intent)
        }

    }
}