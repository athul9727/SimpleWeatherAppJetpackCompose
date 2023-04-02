package com.example.simpleweatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpleweatherapp.screens.MainScreen
import com.example.simpleweatherapp.screens.SplashScreen

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
            MainScreen(weatherController)
        }

    }

}