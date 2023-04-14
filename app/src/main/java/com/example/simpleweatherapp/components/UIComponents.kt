package com.example.simpleweatherapp.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.simpleweatherapp.navigation.WeatherScreen

@Composable
fun showToast(context: Context, showIt: MutableState<Boolean>) {
    if(showIt.value){
        Toast.makeText(context,"city added to favourites", Toast.LENGTH_SHORT).show()
    }
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