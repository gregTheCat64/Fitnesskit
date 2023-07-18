package com.example.fitnesskit.api

import com.example.fitnesskit.models.FitnessObject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://olimpia.fitnesskit-admin.ru/"

private val logging = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val okhttp = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okhttp)
    .build()

interface ApiService {
    @GET("schedule/get_v3/?club_id=2")
    suspend fun getLessons(): Response<FitnessObject>
}

object Api{
    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}