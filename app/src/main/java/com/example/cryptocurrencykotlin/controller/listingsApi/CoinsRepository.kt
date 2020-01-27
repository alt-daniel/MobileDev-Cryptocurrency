package com.example.cryptocurrencykotlin.controller.listingsApi

class CoinsRepository {
    private val coinsApi: CoinApiService = CoinApi.createApi()

    fun getCoinList()= coinsApi.getCoinList()
}