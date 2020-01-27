package com.example.cryptocurrencykotlin.controller.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoinInPortfolio(coinData: CoinData)

    @Query("Select * From coin_table")
    fun getAllCoinsInPortfolio(): LiveData<List<CoinData>>

    @Delete
    suspend fun deleteCoinfromPortfolio(coinData: CoinData)

    @Query("Delete from coin_table")
    suspend fun deletePortfolio()

}