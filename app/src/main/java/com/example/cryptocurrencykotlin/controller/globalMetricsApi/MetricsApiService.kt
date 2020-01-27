package com.example.cryptocurrencykotlin.controller.globalMetricsApi

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface MetricsApiService {

    //getCoinList
    @GET("/v1/global-metrics/quotes/latest?" +
            "CMC_PRO_API_KEY=39be8212-9d7e-46ef-96da-654e68511224")
    fun getGlobalMetrics() : Call<JsonObject>

}