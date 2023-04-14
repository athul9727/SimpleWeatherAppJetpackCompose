package com.example.simpleweatherapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.simpleweatherapp.data.entity.FavouriteEntity
import com.example.simpleweatherapp.navigation.WeatherScreen
import com.example.simpleweatherapp.widgets.WeatherAppBar

@Composable
fun FavouriteScreen(navController: NavController,favouriteViewModel: FavouriteViewModel = hiltViewModel()){
    Scaffold(topBar = {
        WeatherAppBar(
            title = "Favourite Cities",
            isMainScreen = false,
            icon = Icons.Default.ArrowBack,
            navController = navController,
            onButtonClicked = { navController.popBackStack() }
        )
    }) {

        FavouriteContent(favouriteViewModel,navController)

    }
}

@Composable
fun FavouriteContent(favouriteViewModel: FavouriteViewModel,navController: NavController,) {

    androidx.compose.material.Surface(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()) {
         Column(verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally) {

             val list = favouriteViewModel.favList.collectAsState().value
             LazyColumn{
               items(items = list){
                   CityRow(it,navController,favouriteViewModel)
               }
             }

         }
    }
    
}



@Composable
fun CityRow(it: FavouriteEntity, navController: NavController, favouriteViewModel: FavouriteViewModel) {

    Surface(
        modifier = Modifier
            .padding(3.dp)
            .height(50.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(WeatherScreen.MainScreen.name+"/${it.city}")
            },
        shape = RectangleShape,
        color = Color.White
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {


              Text(
                    text = it.city, modifier = Modifier.padding(5.dp), color = Color.Black
                )

            Text(
                text = it.country, modifier = Modifier.padding(5.dp), color = Color.Black
            )

            Icon(imageVector = Icons.Default.Delete, contentDescription = "delete",tint = Color.Red.copy(alpha = 0.5f),
                modifier = Modifier.clickable {
                      favouriteViewModel.deleteFav(fav = it)
            })



        }

    }

}
