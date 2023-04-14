package com.example.simpleweatherapp.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.simpleweatherapp.components.ShowDropDownMenu
import com.example.simpleweatherapp.components.showToast
import com.example.simpleweatherapp.data.entity.FavouriteEntity
import com.example.simpleweatherapp.screens.FavouriteViewModel

@Composable
fun WeatherAppBar(
    title: String = "Title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 5.dp,
    navController: NavController,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {},
    favViewModel:FavouriteViewModel = hiltViewModel()
) {

    val showDialog = remember {
        mutableStateOf(false)
    }

    if (showDialog.value) {
        ShowDropDownMenu(showDialog, navController)
    }

    val showIt = remember {
          mutableStateOf(false)
    }

    val context = LocalContext.current

    TopAppBar(title = {
        Text(
            text = title, color = MaterialTheme.colors.onSecondary,
            style = TextStyle(
                fontWeight = FontWeight.Bold, fontSize = 15.sp
            )
        )
    }, actions = {
        if (isMainScreen) {

            IconButton(onClick = {
                onAddActionClicked.invoke()
            }) {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = "search icon")
            }
            IconButton(onClick = {
                showDialog.value = true
            }) {
                Icon(imageVector = Icons.Default.MoreVert,
                    contentDescription = "more icon")
            }
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

        if(isMainScreen){
            val isAlreadyFavList = favViewModel.favList.collectAsState().value.filter {
                     it.city == title.split(",")[0]
            }
            if(!isAlreadyFavList.isNullOrEmpty()){
                Box(){}
                showIt.value = false
            }
            else {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "favourite icon",
                    tint = Color.Red.copy(alpha = 0.6f),
                    modifier = Modifier
                        .scale(0.9f)
                        .clickable {

                            favViewModel.insertFav(
                                FavouriteEntity(
                                    city = title.split(",")[0],
                                    country = title.split(",")[1]
                                )).run {
                                showIt.value = true
                            }
                        })

            }

            showToast(context = context,showIt)
        }

    }, backgroundColor = Color.Transparent,
        elevation = elevation)


}




