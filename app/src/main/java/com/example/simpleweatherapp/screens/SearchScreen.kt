package com.example.simpleweatherapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.simpleweatherapp.navigation.WeatherScreen
import com.example.simpleweatherapp.widgets.SearchBar
import com.example.simpleweatherapp.widgets.WeatherAppBar


@Composable
fun SearchScreen(navController: NavController){

    Scaffold(topBar = {
        WeatherAppBar(
            title="Search",
            isMainScreen = false,
            icon = Icons.Default.ArrowBack,
            navController = navController,
            onButtonClicked = {
                navController.popBackStack()
            }
        )
    }) {
        
        androidx.compose.material.Surface() {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

             SearchBar(modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.CenterHorizontally)) {
                     navController.navigate(WeatherScreen.MainScreen.name+"/$it")
             }

            }
        }

    }
}