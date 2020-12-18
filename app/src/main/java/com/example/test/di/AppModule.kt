package com.example.test.di

import com.example.test.repository.ApiRepository
import org.koin.dsl.module

val appModule = module {
    single { ApiRepository(get()) }
}
