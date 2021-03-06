package com.example.cryptocurrencykotlin.controller.listingsApi

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface CoinApiService {

    //getCoinList
    @GET("/v1/cryptocurrency/listings/latest?" +
            "CMC_PRO_API_KEY=39be8212-9d7e-46ef-96da-654e68511224" +
            "&limit=20")
    fun getCoinList() : Call<JsonObject>

}