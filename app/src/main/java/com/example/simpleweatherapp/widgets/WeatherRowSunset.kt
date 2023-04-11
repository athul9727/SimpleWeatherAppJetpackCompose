package com.example.simpleweatherapp.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.simpleweatherapp.R
import com.example.simpleweatherapp.model.City
import com.example.simpleweatherapp.utils.formatDatetime

@Composable
fun WeatherRowSunset(cityData: City) {

    Row(
        Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(modifier = Modifier.padding(4.dp)) {

            Icon(
                painter = painterResource(id = R.drawable.sunrise),
                contentDescription = "sunrise icon",
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = "${cityData.sunrise?.toLong()?.formatDatetime()}",
                style = MaterialTheme.typography.caption
            )


        }



        Row(modifier = Modifier.padding(4.dp)) {

            Icon(
                painter = painterResource(id = R.drawable.sunset),
                contentDescription = "sunset icon",
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = "${cityData.sunset?.toLong()?.formatDatetime()}",
                style = MaterialTheme.typography.caption
            )

        }

    }

}