package com.example.simpleweatherapp.screens

import androidx.lifecycle.ViewModel
import com.example.simpleweatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    

}