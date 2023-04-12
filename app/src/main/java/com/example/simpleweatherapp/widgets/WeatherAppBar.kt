package com.example.simpleweatherapp.widgets

import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 5.dp,
    navController: NavController,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
) {

    TopAppBar(title = {
        Text(
            text = title, color = MaterialTheme.colors.onSecondary, style = TextStyle(
                fontWeight = FontWeight.Bold, fontSize = 15.sp
            )
        )
    }, actions = {
        if (isMainScreen) {
            IconButton(onClick = {
                      onAddActionClicked.invoke()
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "search icon")
            }
            IconButton(onClick = {

            }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "more icon")
            }
        } else {

        }

    }, navigationIcon = {
        if (icon != null) {

            Icon(
                imageVector = icon,
                contentDescription = "icon",
                tint = MaterialTheme.colors.onSecondary,
                modifier = Modifier.clickable {
                    onButtonClicked.invoke()
                })


        }
    }, backgroundColor = Color.Transparent, elevation = elevation)


}