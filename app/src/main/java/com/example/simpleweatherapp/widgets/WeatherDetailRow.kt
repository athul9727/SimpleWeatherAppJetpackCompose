package com.example.simpleweatherapp.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.simpleweatherapp.model.DataList
import com.example.simpleweatherapp.utils.formatDate
import com.example.simpleweatherapp.utils.formatDecimals


@Composable
fun WeatherDetailRow(weatherData: DataList) {

    val imgIconUrl = "https://openweathermap.org/img/wn/${weatherData.weather?.get(0)?.icon}.png"


    Surface(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = RectangleShape,
        color = Color.White
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            weatherData.dt?.toLong()?.let {
                Text(text = it.formatDate().split(",")[0], modifier = Modifier.padding(5.dp))
            }

            WeatherStateImage(imageUrl = imgIconUrl)

            Surface(
                shape = CircleShape,
                color = Color.Yellow
            )
            {

                weatherData.weather?.get(0)?.description?.let {
                    Text(
                        text = it,
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.caption
                    )
                }

            }

            Text(text = buildAnnotatedString
            {

                withStyle(
                    style = SpanStyle(
                        color = Color.Blue.copy(alpha = 0.7f),
                        fontWeight = FontWeight.SemiBold
                    )
                )
                {
                    weatherData.main?.tempMax?.formatDecimals()?.let { append("$it°") }!!
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue.copy(alpha = 0.7f),
                        fontWeight = FontWeight.SemiBold
                    )
                )
                {
                    weatherData.main?.tempMin?.formatDecimals()?.let { append("$it°") }
                }


            })

        }

    }

}

