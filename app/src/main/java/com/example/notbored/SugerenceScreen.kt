package com.example.notbored

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SugerenceScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sugerence_screen)

        val randomTitle = intent.getStringExtra("RandomSugerence")
        val title = intent.getStringExtra("titleSugerence")


        val tv_titleSugerence = findViewById<TextView>(R.id.tv_TitleSugerence)
        val tv_prize = findViewById<TextView>(R.id.tv_prize)
        val tv_participants = findViewById<TextView>(R.id.tv_participants)
        val btn_tryAnother = findViewById<Button>(R.id.btn_tryAnother)
        val ibtn_toActivities = findViewById<ImageButton>(R.id.ibtn_toActivityMenu)


        if (intent.hasExtra("titleSugerence")){
            tv_titleSugerence.text = title
            ActivitySearch(title.toString().lowercase())
            Log.d("esta es mi actividad", title.toString())
        } else {
            tv_titleSugerence.text = randomTitle
            ActivityRandomSearch()
        }



        ibtn_toActivities.setOnClickListener {
            val intent = Intent(this, Activities::class.java)
            startActivity(intent)
        }
        btn_tryAnother.setOnClickListener {ActivityRandomSearch()}


    }

    private fun getRetroFit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



     private fun ActivityRandomSearch() {

        CoroutineScope(Dispatchers.IO).launch {

            val call = getRetroFit().create(ApiService :: class.java)
                .getDataApi("activity/")

            val called: dataApi? = call.body()

            runOnUiThread{
                if(call.isSuccessful){
                    val priceActivity = called?.price
                    val activitySelect = called?.activity
                    val tv_prize = findViewById<TextView>(R.id.tv_prize)
                    val tv_participants = findViewById<TextView>(R.id.tv_participants)
                    tv_prize.text = priceActivity.toString()
                    tv_participants.text = activitySelect

                }
            }

        }
    }


    private fun ActivitySearch(query : String) {

        CoroutineScope(Dispatchers.IO).launch {

            val call = getRetroFit().create(ApiService :: class.java)
                .getSpecificData(query)

            val called: dataApiunique? = call.body()

            runOnUiThread{
                if(call.isSuccessful){
                    val priceActivity = called?.price
                    val activitySelect = called?.activity
                    val tv_prize = findViewById<TextView>(R.id.tv_prize)
                    val tv_activity = findViewById<TextView>(R.id.tv_activity)

                    priceActivity?.let {
                        if (priceActivity == 0.0) {
                            tv_prize.text = "Free"
                        } else if(priceActivity > 0.0 && priceActivity < 0.3) {
                            tv_prize.text = "Low"
                        } else if (priceActivity > 0.3 && priceActivity < 0.6) {
                            tv_prize.text = "Medium"
                        } else {
                            tv_prize.text = "High"
                        }
                    }
                    tv_activity.setText(activitySelect)

                }else{
                    Log.d("no lo logre", called?.price.toString())
                }
            }

        }
    }
}