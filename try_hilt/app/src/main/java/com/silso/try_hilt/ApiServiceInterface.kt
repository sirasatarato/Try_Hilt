package com.silso.try_hilt

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {
    @GET("/posts/{id}")
    fun getUserInfo(@Path("id") id: Int): Call<UserData>
}