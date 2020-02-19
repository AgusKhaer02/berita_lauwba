package com.latihan.berita_lauwba.network

import retrofit2.http.GET

interface ApiService {


        @GET("select_berita")
        fun select_berita()
}