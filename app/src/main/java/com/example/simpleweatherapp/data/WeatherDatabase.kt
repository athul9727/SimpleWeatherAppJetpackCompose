package com.example.simpleweatherapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simpleweatherapp.data.entity.FavouriteEntity

@Database(entities = [FavouriteEntity::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

}