package com.example.cryptocurrencykotlin.controller.globalMetricsApi

import com.google.gson.annotations.SerializedName

data class Data (

    @SerializedName("active_cryptocurrencies") val active_cryptocurrencies : Int,
    @SerializedName("total_cryptocurrencies") val total_cryptocurrencies : Int,
    @SerializedName("active_market_pairs") val active_market_pairs : Int,
    @SerializedName("active_exchanges") val active_exchanges : Int,
    @SerializedName("total_exchanges") val total_exchanges : Int,
    @SerializedName("eth_dominance") val eth_dominance : Double,
    @SerializedName("btc_dominance") val btc_dominance : Double,
    @SerializedName("quote") val quote : Quote,
    @SerializedName("last_updated") val last_updated : String
)