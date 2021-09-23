package com.example.notbored

import com.google.gson.annotations.SerializedName

data class dataApi(
    @SerializedName("type") val type: String,
    @SerializedName("price") val price: Double,
    @SerializedName("activity") val activity: String)

data class dataApiunique(
    val activity: String,
    val price: Double)
