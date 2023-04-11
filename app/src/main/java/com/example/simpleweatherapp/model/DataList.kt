package com.example.simpleweatherapp.model
import com.google.gson.annotations.SerializedName

data class DataList(
    @SerializedName("clouds")
    var clouds: Clouds?,
    @SerializedName("dt")
    var dt: Int?,
    @SerializedName("dt_txt")
    var dtTxt: String?,
    @SerializedName("main")
    var main: Main?,
    @SerializedName("pop")
    var pop: Double?,
    @SerializedName("rain")
    var rain: Rain?,
    @SerializedName("sys")
    var sys: Sys?,
    @SerializedName("visibility")
    var visibility: Int?,
    @SerializedName("weather")
    var weather: List<Weather?>?,
    @SerializedName("wind")
    var wind: Wind?
)