package com.example.simpleweatherapp.navigation

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.simpleweatherapp.screens.*
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

        val route = WeatherScreen.MainScreen.name

        composable(
            route= "$route/{city}",
            arguments = listOf( navArgument(name = "city"){ type = NavType.StringType } ))
          {

              it.arguments?.getString("city").let {city->
                  val viewModel = hiltViewModel<MainViewModel>()
                  if (city != null) {
                      MainScreen(weatherController, viewModel,city)
                  }
              }




           }

        composable(WeatherScreen.SearchScreen.name){

            SearchScreen(weatherController)
        }

        composable(WeatherScreen.FavouriteScreen.name){

            FavouriteScreen(weatherController)
        }


        composable(WeatherScreen.SettingsScreen.name){

            SettingsScreen(weatherController)
        }

    }

}