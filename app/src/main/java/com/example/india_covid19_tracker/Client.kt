package com.example.india_covid19_tracker

import okhttp3.OkHttpClient
import okhttp3.Request


object Client {
    private val httpClient= OkHttpClient()
    val request = Request.Builder()
        .url("https://api.covid19india.org/data.json")
        .build()
    val api= httpClient.newCall(request)
}