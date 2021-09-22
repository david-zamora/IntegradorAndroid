package com.example.notbored

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.notbored.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionButtonTerms = findViewById<TextView>(R.id.btn_terms)
        val actionButtonStart = findViewById<Button>(R.id.btn_Start)

        actionButtonStart.setOnClickListener {
                    val intent : Intent = Intent(this, Activities :: class.java)
                    startActivity(intent)
                }

        actionButtonTerms.setOnClickListener {
                val intent: Intent = Intent(this, TermsAndConditions :: class.java)
                startActivity(intent)
            }
        }



        private fun getRetroFit() : Retrofit{
            return Retrofit.Builder()
                .baseUrl("http://www.boredapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun ActivitySearch() {

            CoroutineScope(Dispatchers.IO).launch {

                val call = getRetroFit().create(ApiService :: class.java)
                    .getDataApi("activity/")

                val called: dataApi? = call.body()


            }
        }

    }



