package com.example.notbored

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class SugerenceScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sugerence_screen)

        val randomTitle = intent.getStringExtra("RandomSugerence")
       val title = intent.getStringExtra("titleSugerence")

        var prize = 0.5

        val tv_titleSugerence = findViewById<TextView>(R.id.tv_TitleSugerence)
        val tv_prize = findViewById<TextView>(R.id.tv_prize)
        val tv_participants = findViewById<TextView>(R.id.tv_participants)
        val btn_tryAnother = findViewById<Button>(R.id.btn_tryAnother)
        val ibtn_toActivities = findViewById<ImageButton>(R.id.ibtn_toActivityMenu)


        if (intent.hasExtra("titleSugerence")){
            tv_titleSugerence.text = title
        } else {
            tv_titleSugerence.text = randomTitle
        }

        if (prize == 0.0) {
            tv_prize.text = "Free"
        } else if(prize > 0.0 && prize < 0.3) {
            tv_prize.text = "Low"
        } else if (prize > 0.3 && prize < 0.6) {
            tv_prize.text = "Medium"
        } else {
            tv_prize.text = "High"
        }


        ibtn_toActivities.setOnClickListener {
            val intent = Intent(this, Activities::class.java)
            startActivity(intent)
        }
        btn_tryAnother.setOnClickListener {

        }




    }
}