package com.example.diana.finalapplication

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST


interface Service {

    @GET("items/")
    fun getItems () : Call<List<Item>>

    @POST("items/")
    fun insertItem (item : Item)
}