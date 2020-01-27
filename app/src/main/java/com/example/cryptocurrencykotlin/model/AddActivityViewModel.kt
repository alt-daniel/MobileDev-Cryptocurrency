package com.example.cryptocurrencykotlin.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cryptocurrencykotlin.controller.data.CoinData
import com.example.cryptocurrencykotlin.controller.data.CoinRoomRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivityViewModel (application: Application) : AndroidViewModel(application) {

    private val coinRoomRepository = CoinRoomRepository(application.applicationContext)
    private val ioScope = CoroutineScope(Dispatchers.IO)
    val coins = coinRoomRepository.getAllCoins()

    fun insertCoin(coinData: CoinData) {
        ioScope.launch {
            coinRoomRepository.insertCoin(coinData)
        }
    }

    fun deleteCoin(coinData: CoinData) {
        ioScope.launch {
            coinRoomRepository.deleteCoin(coinData)
        }
    }


}