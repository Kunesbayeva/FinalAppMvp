package com.example.diana.finalapplication

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by gaukhar on 10.12.18.
 */

@Database(entities = arrayOf(Item::class), version = 1)
abstract class Database : RoomDatabase(){
    abstract fun itemDao() : Dao
}