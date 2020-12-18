package com.example.test.network

import com.example.test.model.DataResponse
import retrofit2.http.GET

interface ApiService {
    @GET("test_app.json")
    suspend fun fetchData(): List<DataResponse>
}