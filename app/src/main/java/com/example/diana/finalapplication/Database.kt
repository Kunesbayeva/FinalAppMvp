package com.example.diana.finalapplication

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities = arrayOf(Item::class), version = 1)
abstract class Database : RoomDatabase(){
    abstract fun itemDao() : Dao
}