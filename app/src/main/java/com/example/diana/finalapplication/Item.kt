package com.example.diana.finalapplication

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey



@Entity(tableName = "items")
data class Item(

        @PrimaryKey(autoGenerate = true)
        val id : Int,
        val name : String,
        val mobile : String,
        val home : String,
        val work : String
)