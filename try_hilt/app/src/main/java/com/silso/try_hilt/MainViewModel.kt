package com.silso.try_hilt

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class MainViewModel @ViewModelInject constructor(private val apiService: ApiServiceInterface) :
    ViewModel() {

    suspend fun getUserRequest(id: Int): Result<UserData> {
        return safeApiCall(call = { apiService.getUserInfo(id) })
    }
}