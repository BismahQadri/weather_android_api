package com.e.weatherapi.datasource.remote

data class ApiResult<T>(
val cod: Int,
val data: T?,
val message: String?
)