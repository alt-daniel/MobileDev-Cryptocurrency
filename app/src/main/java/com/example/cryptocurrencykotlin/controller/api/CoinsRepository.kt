package com.example.cryptocurrencykotlin.controller.api

import com.example.cryptocurrencykotlin.controller.api.CoinApi
import com.example.cryptocurrencykotlin.controller.api.CoinApiService

class CoinsRepository {
    private val coinsApi: CoinApiService = CoinApi.createApi()

    fun getCoinList()= coinsApi.getCoinList()
}