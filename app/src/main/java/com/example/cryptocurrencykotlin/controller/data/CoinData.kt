package com.example.cryptocurrencykotlin.controller.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin_table")
data class CoinData(
    var name: String,
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var price: Double
)