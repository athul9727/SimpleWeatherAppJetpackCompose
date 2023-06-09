package com.example.simpleweatherapp.screens

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleweatherapp.data.DataOrException
import com.example.simpleweatherapp.model.Weather
import com.example.simpleweatherapp.model.WeatherModel
import com.example.simpleweatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {


//    val data : MutableState<DataOrException<WeatherModel,Boolean,java.lang.Exception>> = mutableStateOf(
//        DataOrException(null,true,java.lang.Exception(""))
//    )

    init {
          // getWeather("calicut")
    }

     suspend fun getWeather(city:String) :DataOrException<WeatherModel,Boolean,Exception> {
            return weatherRepository.getWeather(city = city)

    }

}