package com.example.cryptocurrencykotlin.controller.globalMetricsApi

import com.google.gson.annotations.SerializedName

data class Quote (

    @SerializedName("USD") val uSD : USD
)