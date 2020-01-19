package com.e.weatherapi.datasource.weather

import com.e.weatherapi.datasource.models.WeatherMain
import com.e.weatherapi.datasource.remote.ApiResult
import com.e.weatherapi.utilities.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiInterface {
    @GET()
    fun getWeather(
        @Query("q") country :String,
        @Query("APPID")  apiKey : String = API_KEY
    ): Call<ApiResult<WeatherMain>>
}