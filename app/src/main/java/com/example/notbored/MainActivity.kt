package com.example.notbored

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.notbored.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText




class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionButtonTerms = findViewById<TextView>(R.id.tv_terms)
        val actionButtonStart = findViewById<Button>(R.id.btn_Start)

        val tv_terms = findViewById<TextView>(R.id.tv_terms)

        val et_participants = findViewById<EditText>(R.id.txt_number)



        actionButtonStart.setOnClickListener {

            val intent : Intent = Intent(this, Activities :: class.java)
                    startActivity(intent)
                }

        actionButtonTerms.setOnClickListener {
                val intent: Intent = Intent(this, TermsAndConditions :: class.java)
                startActivity(intent)
            }
        }






    }



