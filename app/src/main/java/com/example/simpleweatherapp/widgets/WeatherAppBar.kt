package com.example.simpleweatherapp.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simpleweatherapp.navigation.WeatherScreen

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

    val showDialog = remember {
        mutableStateOf(false)
    }

    if (showDialog.value) {
        ShowDropDownMenu(showDialog, navController)
    }

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
                showDialog.value = true
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

@Composable
fun ShowDropDownMenu(showDialog: MutableState<Boolean>, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
            .absolutePadding(top = 45.dp, right = 25.dp)
    ) {

        var expanded by remember {
            mutableStateOf(true)
        }
        val items = listOf<String>("Favourites", "About", "Settings")
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }, modifier = Modifier
                .width(140.dp)
                .background(Color.White)
        ) {

            items.forEachIndexed { index, s ->

                DropdownMenuItem(onClick = {
                    expanded = false
                    showDialog.value = false
                }) {

                    Icon(
                        imageVector = when (index) {

                            0 -> Icons.Default.Favorite
                            1 -> Icons.Default.Info
                            else -> Icons.Default.Settings

                        }, contentDescription = "drop down menu"
                    )

                    Text(text = s, modifier = Modifier.clickable {

                                       if(index==0){
                                            navController.navigate(WeatherScreen.FavouriteScreen.name)
                                       }

                    }, fontWeight = FontWeight.W300)

                }

            }

        }

    }
}
