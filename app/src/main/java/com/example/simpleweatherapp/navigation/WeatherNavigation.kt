package com.example.simpleweatherapp.navigation

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpleweatherapp.screens.MainScreen
import com.example.simpleweatherapp.screens.MainViewModel
import com.example.simpleweatherapp.screens.SplashScreen
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun WeatherNavigation() {

    val weatherController =  rememberNavController()
    
    NavHost(
        navController = weatherController,
        startDestination = WeatherScreen.SplashScreen.name ) {

        composable(WeatherScreen.SplashScreen.name){
            SplashScreen(weatherController)
        }
        composable(WeatherScreen.MainScreen.name){

            val viewModel = hiltViewModel<MainViewModel>()

            MainScreen(weatherController, viewModel)
        }

    }

}