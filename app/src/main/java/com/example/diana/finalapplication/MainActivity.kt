package com.example.diana.finalapplication

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private lateinit var adapter : Adapter
    private var list = ArrayList<Item>()
    private lateinit var retrofit : Retrofit
    private lateinit var service : Service
    private lateinit var database : Database


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = Adapter(this, list)
        recyclerView.adapter = adapter

        database = Room.databaseBuilder(this, Database::class.java, "itemsDB")
                .allowMainThreadQueries()
                .build()

        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { })
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client =  OkHttpClient.Builder()
                .connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build()

        retrofit = Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/Kunesbayeva/FinalAppMvp/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(Service::class.java)


        /*service.getItems().enqueue(object : Callback<List<Item>> {
            fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                log("response " + response.body()!!.size)
            }

            fun onFailure(call: Call<List<Item>>, t: Throwable) {

            }
        })*/


    }

    override fun onResume() {
        super.onResume()

        //List from room
        database.itemDao().getItems().subscribe {
            list.addAll(it)
        }

    }
}
