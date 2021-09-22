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
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionButtonStart = findViewById<Button>(R.id.btn_Start)

        val tv_terms = findViewById<TextView>(R.id.tv_terms)

        var sharedPrefs = getSharedPreferences("prefs" , MODE_PRIVATE)

        val et_participants = findViewById<EditText>(R.id.txt_number)

        val numberOfParticipants = et_participants.text.toString().toInt()


        actionButtonStart.setOnClickListener {

            val intent : Intent = Intent(this, Activities :: class.java)
                    startActivity(intent)

                }
        }
    }



