package com.example.simpleweatherapp.widgets

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun WeatherAppBar(
    title: String = "Title",
    icon: ImageVector?=null,
    isMainScreen: Boolean = true,
    elevation: Dp = 0.dp,
    navController: NavController,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
) {

    TopAppBar(title = {
        Text(text = title, color = MaterialTheme.colors.onSecondary, style = TextStyle(
            fontWeight = FontWeight.Bold, fontSize = 15.sp
        ))
    }, actions = {

    }, navigationIcon = {

    }, backgroundColor = Color.Transparent, elevation = elevation)


        


 }