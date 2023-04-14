package com.example.simpleweatherapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import com.example.simpleweatherapp.data.DataOrException
import com.example.simpleweatherapp.model.DataList
import com.example.simpleweatherapp.model.WeatherModel
import com.example.simpleweatherapp.navigation.WeatherScreen
import com.example.simpleweatherapp.utils.formatDate
import com.example.simpleweatherapp.utils.formatDecimals
import com.example.simpleweatherapp.widgets.*

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel,cityArgs: String) {
    val weatherData = produceState<DataOrException<WeatherModel, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = viewModel.getWeather(cityArgs)
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
        WeatherAppBar(
            title = "${weatherData.city?.name} ,${weatherData.city?.country}",
            navController = navController,
            onAddActionClicked = {
                    navController.navigate(WeatherScreen.SearchScreen.name)
            },

        )
    }) {

        MainContent(weatherData)

    }

}

@Composable
fun MainContent(weatherData: WeatherModel) {

    val weatherItem = weatherData.list?.get(0)
    val imgIconUrl = "https://openweathermap.org/img/wn/${weatherItem?.weather?.get(0)?.icon}.png"

    Column(
        Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        weatherItem?.dt?.toLong()?.let {
            Text(
                text = it.formatDate(),
                color = MaterialTheme.colors.onSecondary,
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(6.dp)
            )
        }

        Surface(
            Modifier
                .padding(4.dp)
                .size(200.dp), shape = CircleShape, color = Color(0xFFFFC400)
        ) {


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                WeatherStateImage(imageUrl = imgIconUrl)
                weatherItem?.main?.temp?.let {
                    Text(
                        text = it.formatDecimals() + "°",
                        style = MaterialTheme.typography.h4
                    )
                }
                weatherItem?.weather?.get(0)?.main?.let {
                    Text(
                        text = it,
                        fontStyle = FontStyle.Italic,
                        fontSize = 18.sp
                    )
                }
                weatherItem?.weather?.get(0)?.description?.let {
                    Text(
                        text = it,
                        fontStyle = FontStyle.Italic,
                        fontSize = 16.sp
                    )
                }
            }

        }

        if (weatherItem != null) {
            WeatherRowHumidity(weather = weatherItem)
            Divider()
            weatherData.city?.let { WeatherRowSunset(cityData = it) }
        }

        Text(
            text = "This Week",
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color.Transparent,
            shape = RoundedCornerShape(size = 14.dp)
        ) {

            LazyColumn(
                modifier = Modifier.padding(2.dp), contentPadding = PaddingValues(1.dp)
            ) {

                items(items = weatherData.list!!) { weatherItem: DataList? ->

                    if (weatherItem != null) {
                        WeatherDetailRow(weatherItem)
                    }

                }
            }

        }

    }
}


