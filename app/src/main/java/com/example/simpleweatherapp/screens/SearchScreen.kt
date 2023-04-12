package com.example.simpleweatherapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.simpleweatherapp.navigation.WeatherScreen
import com.example.simpleweatherapp.widgets.WeatherAppBar


@Composable
fun SearchScreen(navController: NavController){

    Scaffold(topBar = {
        WeatherAppBar(
            title="Search",
            isMainScreen = false,
            icon = Icons.Default.ArrowBack,
            navController = navController,
            onAddActionClicked = {
                navController.popBackStack()
            }
        )
    }) {
        
        androidx.compose.material.Surface() {
            Column() {

            }
        }

    }
}