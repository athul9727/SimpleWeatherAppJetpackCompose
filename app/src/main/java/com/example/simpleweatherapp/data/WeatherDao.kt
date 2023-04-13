package com.example.simpleweatherapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.simpleweatherapp.data.Entity.FavouriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM FavTable")
    fun getFavorites() : Flow<List<FavouriteEntity>>

    @Query("SELECT * FROM FavTable where city = :city")
    suspend fun getFavoriteByCity(city:String) : FavouriteEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFav(fav:FavouriteEntity)

    @Delete
    suspend fun removeFav(fav:FavouriteEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFav(fav:FavouriteEntity)

    @Query("DELETE FROM FavTable")
    suspend fun deleteAllFav()

}