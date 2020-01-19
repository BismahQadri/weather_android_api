package com.e.weatherapi.datasource.remote

interface ApiCallback<T> {
    fun onFailure(t: Throwable)
    fun onError(code: String, message: String)
    fun onSuccess(data: T)
}
