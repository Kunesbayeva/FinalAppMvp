package com.example.diana.finalapplication

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by gaukhar on 10.12.18.
 */

@Entity(tableName = "items")
data class Item(

        @PrimaryKey(autoGenerate = true)
        val id : Int,

        val name : String,
        val title : String
)