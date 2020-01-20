package com.e.weatherapi.datasource.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallbackImpl<T> (
    private val callback: ApiCallback<T>
) : Callback<ApiResult<T>> {
    override fun onFailure(call: Call<ApiResult<T>>, t: Throwable) {
        callback.onFailure(t)
    }

    override fun onResponse(call: Call<ApiResult<T>>, response: Response<ApiResult<T>>) {
        if (!response.isSuccessful && response.errorBody() != null) {
            val apiResult = response.body()
            apiResult ?: callback.onFailure(Throwable("Failed to connect"))
            val code = apiResult?.cod ?: ""
            if (code == "200"){
                callback.onSuccess(apiResult?.data)
            } else
                callback.onError(apiResult?.message)
        }

    }
}

