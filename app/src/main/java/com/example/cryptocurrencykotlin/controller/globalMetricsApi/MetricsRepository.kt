package com.example.cryptocurrencykotlin.controller.globalMetricsApi

class MetricsRepository {
    private val metricsApi: MetricsApiService = MetricsApi.createApi()

    fun getGlobalMetrics()= metricsApi.getGlobalMetrics()
}