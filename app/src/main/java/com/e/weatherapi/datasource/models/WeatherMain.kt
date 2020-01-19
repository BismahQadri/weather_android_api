package com.e.weatherapi.datasource.models

data class WeatherMain(val coord: Coord?, val weather: List<Weather>?, val base: String?, val main: Main?, val visibility: Long?, val wind: Wind?, val clouds: Clouds?, val dt: Long?, val sys: Sys?, val timezone: Long?, val id: Long?, val name: String?)

data class Clouds(val all: Long?)

data class Coord(val lon: Long?, val lat: Long?)

data class Main(val temp: Long?, val feels_like: Long?, val temp_min: Long?, val temp_max: Long?, val pressure: Long?, val humidity: Long?)

data class Sys(val type: Long?, val id: Long?, val country: String?, val sunrise: Long?, val sunset: Long?)

data class Weather(val id: Long?, val main: String?, val description: String?, val icon: String?)

data class Wind(val speed: Long?, val deg: Long?)