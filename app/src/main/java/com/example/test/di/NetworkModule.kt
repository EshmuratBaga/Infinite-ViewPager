package com.example.test.di

import com.example.test.network.ApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val TIME_OUT_SECOND = 60L

val networkModule = module {
    single { provideOkhttpClient() }
    single { createWebService<ApiService>(get(), "https://lovetest.me/a_test_1/") }
}


fun provideOkhttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT_SECOND, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT_SECOND, TimeUnit.SECONDS)
        .writeTimeout(TIME_OUT_SECOND, TimeUnit.SECONDS)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(T::class.java)
}
