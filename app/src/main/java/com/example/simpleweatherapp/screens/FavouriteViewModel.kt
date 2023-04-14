package com.example.simpleweatherapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleweatherapp.data.entity.FavouriteEntity
import com.example.simpleweatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _favList = MutableStateFlow<List<FavouriteEntity>>(listOf())
    val favList = _favList.asStateFlow()



    init{
        viewModelScope.launch(Dispatchers.IO) {
           weatherRepository.getFavourites().distinctUntilChanged().collect{
               _favList.emit(it)
           }
        }
    }

    fun insertFav(fav:FavouriteEntity) = viewModelScope.launch(Dispatchers.IO) {  weatherRepository.insertFav(fav) }
    fun updateFav(fav:FavouriteEntity) = viewModelScope.launch(Dispatchers.IO) {  weatherRepository.updateFav(fav) }

    fun deleteFav(fav:FavouriteEntity) = viewModelScope.launch(Dispatchers.IO) {  weatherRepository.deleteFav(fav) }

    fun deleteAllFav() = viewModelScope.launch(Dispatchers.IO) {  weatherRepository.deleteAllFavs() }

    fun getFavByCity(city:String): FavouriteEntity? {
        var fav:FavouriteEntity? = null
        viewModelScope.launch(Dispatchers.IO) {
          fav =  weatherRepository.getFavouriteByCity(city)

        }
        return fav
    }


}