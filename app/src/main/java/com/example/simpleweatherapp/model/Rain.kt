package com.example.simpleweatherapp.model
import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("3h")
    var h: Double?
)