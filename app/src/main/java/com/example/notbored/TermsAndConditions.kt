package com.example.notbored

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class TermsAndConditions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_and_conditions)

        val btn_exitTerms = findViewById<ImageButton>(R.id.btn_exitTerms)

        btn_exitTerms.setOnClickListener {

            val intent : Intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }
    }
}