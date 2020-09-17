package com.silso.try_hilt

import retrofit2.Response

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Result<T> {
    return try {
        val myResp = call.invoke()

        if (myResp.isSuccessful) {
            Result.Success(myResp.body()!!)
        } else {
            Result.Error(myResp.errorBody()?.string() ?: "Something goes wrong")
        }

    } catch (e: Exception) {
        Result.Error(e.message ?: "Internet error runs")
    }
}