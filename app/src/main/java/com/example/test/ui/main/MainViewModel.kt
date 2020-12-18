package com.example.test.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.model.DataResponse
import com.example.test.repository.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainViewModel constructor(val repository: ApiRepository) : ViewModel() {
    val data: MutableLiveData<List<DataResponse>> = MutableLiveData()
    val error: MutableLiveData<Boolean> = MutableLiveData()
    val loading: MutableLiveData<Boolean> = MutableLiveData()
    var dataList: List<DataResponse> = emptyList()

    fun fetchData() {
        loading.value = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    loading.postValue(false)
                    val body = repository.fetchData()
                    data.postValue(body)
                    dataList = body
                } catch (e: Exception) {
                    loading.postValue(false)
                    error.postValue(true)
                }
            }
        }
    }
}