package com.example.simpleweatherapp.repository

import android.util.Log
import com.example.simpleweatherapp.data.DataOrException
import com.example.simpleweatherapp.model.WeatherModel
import com.example.simpleweatherapp.network.WeatherApi
import com.google.gson.Gson
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) {

    suspend fun getWeather(city:String) : DataOrException<WeatherModel,Boolean,Exception> {

        val response  = try {
             weatherApi.getWeather(city)
        }
        catch (e:Exception){
            Log.e("EXCEPTION", e.toString())
            return DataOrException(e=e)
        }

        Log.e("RESPONSE", Gson().toJson(response))

        return DataOrException(data = response)

    }




}