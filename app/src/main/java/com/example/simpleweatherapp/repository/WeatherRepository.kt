package com.example.simpleweatherapp.repository

import com.example.simpleweatherapp.data.DataOrException
import com.example.simpleweatherapp.model.WeatherModel
import com.example.simpleweatherapp.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) {

    suspend fun getWeather(city:String) : DataOrException<WeatherModel,Boolean,Exception> {

        val response  = try {
             weatherApi.getWeather(city)
        }
        catch (e:Exception){
            return DataOrException(e=e)
        }

        return DataOrException(data = response)

    }




}