package com.e.weatherapi.datasource.weather

import com.e.weatherapi.datasource.models.WeatherMain
import com.e.weatherapi.datasource.remote.ApiCallback
import com.e.weatherapi.datasource.remote.ApiClient

class WeatherService  private constructor(
) {

    companion object {
        val instance: WeatherService by lazy { WeatherService() }

        fun getInstanceObject(): WeatherService {
            return instance
        }

        fun getWeather(country: String, callback: ApiCallback<WeatherMain>)  {
            val service = ApiClient.retrofit.create(
                WeatherApiInterface:: class.java)
            val call = service.getWeather(country)
            call.enqueue(callback)
        }

    }
}