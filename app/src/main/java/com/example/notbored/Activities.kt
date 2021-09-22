package com.example.notbored

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView

class Activities : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activities)

        val btn_goToSugerence = findViewById<ImageButton>(R.id.ib_toSugerence)

        val arrayAdapter : ArrayAdapter<*>

        val activities = mutableListOf("Education",
            "Recreational", "Social", "Diy", "Charity",
            "Cooking", "Relaxation", "Music", "Busywork")

        val lv_Activities = findViewById<ListView>(R.id.lv_Activities)

        arrayAdapter = ArrayAdapter(this , android.R.layout.simple_list_item_1, activities)
        lv_Activities.adapter = arrayAdapter

        btn_goToSugerence.setOnClickListener {
            val intent : Intent = Intent(this, SugerenceScreen::class.java)
            intent.putExtra("RandomSugerence" , "Random")
            startActivity(intent)

        }

        lv_Activities.setOnItemClickListener(){parent, view, position , id ->

            lateinit var titulo : String

            when (position){
                0 -> titulo = "Education"
                1 -> titulo = "Recreational"
                2 -> titulo = "Social"
                3 -> titulo = "Diy"
                4 -> titulo = "Charity"
                5 -> titulo = "Cooking"
                6 -> titulo = "Relaxation"
                7 -> titulo = "Music"
                8 -> titulo = "Busywork"


            }
            val intent : Intent = Intent(this, SugerenceScreen::class.java)
            intent.putExtra("titleSugerence", "$titulo")
            startActivity(intent)
        }

    }
}