package com.example.cryptocurrencykotlin.controller.globalMetricsApi

import com.google.gson.annotations.SerializedName

data class USD (

    @SerializedName("total_market_cap") val total_market_cap : Double,
    @SerializedName("total_volume_24h") val total_volume_24h : Double,
    @SerializedName("total_volume_24h_reported") val total_volume_24h_reported : Double,
    @SerializedName("altcoin_volume_24h") val altcoin_volume_24h : Double,
    @SerializedName("altcoin_volume_24h_reported") val altcoin_volume_24h_reported : Double,
    @SerializedName("altcoin_market_cap") val altcoin_market_cap : Double,
    @SerializedName("last_updated") val last_updated : String
)