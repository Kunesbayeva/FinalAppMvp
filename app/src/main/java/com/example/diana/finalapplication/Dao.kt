package com.example.diana.finalapplication

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable



@Dao
interface Dao {

    @Query("Select * from items")
    fun getItems () : Flowable<List<Item>>

    @Insert
    fun insertItem (item : Item)
}