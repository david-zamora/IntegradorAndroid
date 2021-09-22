package com.example.notbored

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET
    suspend fun getDataApi(@Url url: String): Response<dataApi>

    //intento hacer el get directo al api especifica
    @GET("activity?type=:type")
    //@query toma el dato tipo query para ser consultado
    fun getSpecificData(@Query("titleSugerence") title: String) : Call<dataApi>

}