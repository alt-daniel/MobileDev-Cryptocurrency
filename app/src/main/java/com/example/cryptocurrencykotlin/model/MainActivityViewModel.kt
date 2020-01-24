package com.example.cryptocurrencykotlin.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cryptocurrencykotlin.controller.api.Coin
import com.example.cryptocurrencykotlin.controller.api.CoinsRepository
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val coinsRepository = CoinsRepository()
    val coins = MutableLiveData<List<Coin>>()
    val error = MutableLiveData<String>()

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
}