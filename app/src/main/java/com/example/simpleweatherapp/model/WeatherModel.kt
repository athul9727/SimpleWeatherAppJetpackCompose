package com.example.simpleweatherapp.model
import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("city")
    var city: City?,
    @SerializedName("cnt")
    var cnt: Int?,
    @SerializedName("cod")
    var cod: String?,
    @SerializedName("list")
    var list: List<DataList?>?,
    @SerializedName("message")
    var message: Int?
)