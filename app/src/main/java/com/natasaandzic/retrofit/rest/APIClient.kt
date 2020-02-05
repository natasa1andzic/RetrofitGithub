package com.natasaandzic.retrofit.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {


companion object {


    private val url = "https://api.github.com/"

    fun getClient() : Retrofit {
            return  Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()

    }
}}