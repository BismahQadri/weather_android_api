package com.e.weatherapi.datasource.remote

interface ApiCallback<T> {
    fun onFailure(t: Throwable)
    fun onError( message: String?)
    fun onSuccess(data: T?)
}
