package com.e.weatherapi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.weatherapi.datasource.models.WeatherMain
import com.e.weatherapi.datasource.remote.ApiCallback
import com.e.weatherapi.datasource.remote.NetworkState
import com.e.weatherapi.datasource.weather.WeatherService
import com.e.weatherapi.utilities.Event

class WeatherViewModel : ViewModel() {

    private val _weatherState = MutableLiveData<Event<NetworkState<WeatherMain>>>()

    val weatherState: LiveData<Event<NetworkState<WeatherMain>>>
        get() {return _weatherState}

    fun getWeather(country: String) {
        _weatherState.value = Event(NetworkState.Loading())
        WeatherService.instance.getWeather(country,
            object : ApiCallback<WeatherMain>{
                override fun onFailure(t: Throwable) {
                    _weatherState.value = Event(NetworkState.Failure(t))
                }

                override fun onError(message: String?) {
                    _weatherState.value = Event(NetworkState.Error(message))

                }

                override fun onSuccess(data: WeatherMain?) {
                    _weatherState.value = Event(NetworkState.Success(data))
                }

            })
    }
}