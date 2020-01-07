package com.example.cryptocurrencykotlin.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class Coin(

    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("cmc_rank") var rank: Int,
    @SerializedName("symbol") var symbol: String,
    @SerializedName("quote") val quote : Quote,
    var pid: Int

) : Parcelable {
    fun getLogofromUrl() : String {
        return "https://s2.coinmarketcap.com/static/img/coins/64x64/${id}.png"
    }
}

