package com.example.cryptocurrencykotlin.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Quote(
    @SerializedName("USD") val usd : USD
) :Parcelable
