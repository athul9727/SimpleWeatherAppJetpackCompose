package com.example.simpleweatherapp.di

import android.content.Context
import androidx.room.Room
import com.example.simpleweatherapp.data.WeatherDao
import com.example.simpleweatherapp.data.WeatherDatabase
import com.example.simpleweatherapp.network.WeatherApi
import com.example.simpleweatherapp.repository.WeatherRepository
import com.example.simpleweatherapp.screens.FavouriteViewModel
import com.example.simpleweatherapp.utils.Constants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): WeatherApi{
             return Retrofit.Builder()
                 .baseUrl(Constants.BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()
                 .create(WeatherApi::class.java)
    }


    @Singleton
    @Provides
    fun provideDao(db: WeatherDatabase) : WeatherDao{
        return db.weatherDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext con: Context) : WeatherDatabase{
        return Room.databaseBuilder(con,WeatherDatabase::class.java,"WeatherDb").fallbackToDestructiveMigration().build()
    }


}