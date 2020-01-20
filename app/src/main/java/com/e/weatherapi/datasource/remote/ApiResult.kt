package com.e.weatherapi.datasource.remote

data class ApiResult<T>(
val cod: String,
val data: T?,
val message: String?
)