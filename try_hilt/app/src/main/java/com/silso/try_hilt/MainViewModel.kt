package com.silso.try_hilt

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainViewModel @ViewModelInject constructor(private val apiService: ApiServiceInterface): ViewModel() {
    fun getUser(id: Int) = liveData(Dispatchers.IO) {
        emit(apiService.getUserInfo(id))
    }
}