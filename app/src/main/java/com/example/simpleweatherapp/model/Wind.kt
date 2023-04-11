package com.example.simpleweatherapp.model
import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    var deg: Int?,
    @SerializedName("gust")
    var gust: Double?,
    @SerializedName("speed")
    var speed: Double?
)