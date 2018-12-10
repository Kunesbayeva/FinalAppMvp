package com.example.diana.finalapplication

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by gaukhar on 10.12.18.
 */
interface Service {

    @GET("your_url")
    fun getItems () : Observable<List<Item>>

    @POST("your_url")
    fun insertItem (item : Item)
}