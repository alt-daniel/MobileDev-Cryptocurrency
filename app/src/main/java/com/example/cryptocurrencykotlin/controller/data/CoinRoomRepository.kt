package com.example.cryptocurrencykotlin.controller.data

import android.content.Context
import androidx.lifecycle.LiveData

class CoinRoomRepository(context: Context) {

    private val coinDao: CoinDao

    init {
        val database =
            CoinRoomDatabase.getDatabase(
                context
            )
        coinDao = database!!.coinDao()
    }

    fun getAllCoins() : LiveData<List<CoinData>> {
        return coinDao.getAllCoinsInPortfolio()
    }

    suspend fun insertCoin(coin: CoinData) {
        return coinDao.insertCoinInPortfolio(coin)
    }

    suspend fun deleteCoin(coin: CoinData) {
        return coinDao.deleteCoinfromPortfolio(coin)
    }

    suspend fun deletePortfolio() {
        return coinDao.deletePortfolio()
    }
}