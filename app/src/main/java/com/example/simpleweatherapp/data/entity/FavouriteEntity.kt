package com.example.simpleweatherapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavTable")
data class FavouriteEntity(
    @PrimaryKey
    @ColumnInfo(name = "City")
    val city:String,
    @ColumnInfo(name = "Country")
    val country:String)
