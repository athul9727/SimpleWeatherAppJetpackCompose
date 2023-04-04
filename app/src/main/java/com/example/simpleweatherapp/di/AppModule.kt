package com.example.simpleweatherapp.di

import com.example.simpleweatherapp.network.WeatherApi
import com.example.simpleweatherapp.utils.Constants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

}