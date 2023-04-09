package com.example.simpleweatherapp.screens

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.navigation.NavController
import com.example.simpleweatherapp.data.DataOrException
import com.example.simpleweatherapp.model.WeatherModel
import com.example.simpleweatherapp.widgets.WeatherAppBar

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    val weatherData = produceState<DataOrException<WeatherModel, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = viewModel.getWeather("calicut")
    }.value

    if (weatherData.loading == true) {
        CircularProgressIndicator()
    } else if (weatherData.data != null) {

        mainScaffold(weatherData.data!!, navController)
    }


}


@Composable
fun mainScaffold(weatherData: WeatherModel, navController: NavController) {

    Scaffold(topBar = {
        WeatherAppBar(title = "qqqq",navController = navController)
    }) {

        MainContent(weatherData)

    }

}

@Composable
fun MainContent(weatherData: WeatherModel) {


}
