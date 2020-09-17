package com.silso.try_hilt

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {
    @GET("/posts/{id}")
    suspend fun getUserInfo(@Path("id") id: Int): Response<UserData>
}