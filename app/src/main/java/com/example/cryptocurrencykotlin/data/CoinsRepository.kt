package com.example.cryptocurrencykotlin.data

class CoinsRepository {
    private val coinsApi: CoinApiService = CoinApi.createApi()

    fun getCoinList()= coinsApi.getCoinList()
}