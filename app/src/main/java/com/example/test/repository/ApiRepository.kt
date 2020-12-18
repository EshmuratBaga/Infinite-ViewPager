package com.example.test.repository

import com.example.test.model.DataResponse
import com.example.test.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ApiRepository(private val api: ApiService) {
    suspend fun fetchData()  = api.fetchData()
}