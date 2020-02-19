package com.latihan.berita_lauwba.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
//

//    COPAS=======================================
//    SUMBER SCRIPT CODE : pastebin.com/zAUX7hXY
//  menggunakan IP sendiri IPv4
    const val BASE_URL = "http://192.168.4.64/ci_berita/index.php/Webservices"
    //BODY, error html terlihat di logcat.
    fun getOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttp())
            .build()
    }

//  memanggilkan file interface ApiService
    fun getService(): ApiService {
        return getRetrofit().create<ApiService>(ApiService::class.java)
    }
//    COPAS===============================


}