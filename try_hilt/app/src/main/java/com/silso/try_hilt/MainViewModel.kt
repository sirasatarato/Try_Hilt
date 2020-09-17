package com.silso.try_hilt

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val apiService: ApiServiceInterface) :
    ViewModel() {

    val post: MutableLiveData<UserData> by lazy {
        MutableLiveData<UserData>()
    }

    val errorMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getUserFromServer(id: Int) {
        viewModelScope.launch {
            val retrofitPost = getUserRequest(id)
            when (retrofitPost) {
                is Result.Success -> { post.postValue(retrofitPost.data)}
                is Result.Error -> {
                    errorMessage.postValue(retrofitPost.exception)
                }
            }
        }
    }

    private suspend fun getUserRequest(id: Int): Result<UserData> {
        return safeApiCall(call = { apiService.getUserInfo(id) })
    }
}