package com.example.cryptocurrencykotlin.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class USD (
    @SerializedName("price") val price : Double,
    @SerializedName("volume_24h") val volume_24h : Double,
    @SerializedName("percent_change_1h") val percent_change_1h : Double,
    @SerializedName("percent_change_24h") val percent_change_24h : Double,
    @SerializedName("percent_change_7d") val percent_change_7d : Double,
    @SerializedName("market_cap") val market_cap : Int,
    @SerializedName("last_updated") val last_updated : String
) : Parcelable