package com.example.cryptocurrencykotlin.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cryptocurrencykotlin.controller.globalMetricsApi.Data
import com.example.cryptocurrencykotlin.controller.globalMetricsApi.MetricsRepository
import com.example.cryptocurrencykotlin.controller.listingsApi.Coin
import com.example.cryptocurrencykotlin.controller.listingsApi.CoinsRepository
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val coinsRepository = CoinsRepository()
    private val metricsRepository = MetricsRepository()
    val coins = MutableLiveData<List<Coin>>()
    val error = MutableLiveData<String>()

    val data = MutableLiveData<Data>()
    val errorData = MutableLiveData<String>()

    fun getCoinList() {
        coinsRepository.getCoinList().enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val results = response.body()?.get("data")
                // puts the results in an array of type coin
                val coins =
                    GsonBuilder().create().fromJson(results, Array<Coin>::class.java).toList()

                //sets the ids
                for ((num, coin) in coins.withIndex()) {
                    coins[num].pid = num+1
                }

                if (response.isSuccessful) this@MainActivityViewModel.coins.value = coins
                else error.value = "An error occured: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                error.value = t.message
            }
        })
    }

    fun getGlobalMetrics() {
        metricsRepository.getGlobalMetrics().enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val results = response.body()?.get("data")
                // puts the results in an array of type coin
                val data =
                    GsonBuilder().create().fromJson(results, Data::class.java)

                //sets the ids

                if (response.isSuccessful) this@MainActivityViewModel.data.value = data
                else errorData.value = "An error occured: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                errorData.value = t.message
            }
        })
    }

}