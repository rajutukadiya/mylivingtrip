package com.mylivingtrip.app.activity.homescreen.response

import androidx.annotation.Keep


@Keep
data class CityResponse(
    val flightcity: List<Flightcity>,
    val status: Boolean
)

@Keep
data class Flightcity(
    val airportCity: String,
    val airportCode: String,
    val airportCountry: String,
    val airportName: String
)