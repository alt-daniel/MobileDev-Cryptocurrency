package com.example.cryptocurrencykotlin.data

import android.content.Context
import android.graphics.Color
import android.icu.text.DecimalFormat
import android.icu.text.DecimalFormatSymbols
import android.icu.text.NumberFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cryptocurrencykotlin.R
import kotlinx.android.synthetic.main.item_coin.view.*
import java.math.BigDecimal
import java.util.*
import kotlin.math.roundToInt

class CoinAdapter (private val coinList: List<Coin>, private val onClick: (Coin) -> Unit) :  RecyclerView.Adapter<CoinAdapter.Viewholder>() {

    private lateinit var context: Context
    private var coinNum = 0

    override fun getItemCount(): Int {
        return coinList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        return Viewholder(
            LayoutInflater.from(context).inflate(R.layout.item_coin, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(coinList[position])
    }

    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener{
                onClick(coinList[adapterPosition])
            }
        }

        fun bind(coin: Coin) {

            itemView.tvSymbol.text = coin.symbol
            itemView.tvName.text = coin.name
            itemView.tvPrice.text = coin.quote.usd.price.toString() + " USD"

            val percentChange = coin.quote.usd.percent_change_1h
            val twoDigits = String.format("%.2f", percentChange)
            if (percentChange > 0){
                itemView.tvChanged.setTextColor(Color.parseColor("#00574B"))
            } else itemView.tvChanged.setTextColor(Color.parseColor("#EE0235"))

            itemView.tvChanged.text = twoDigits + " %"
            Glide.with(context).load(coin.getLogofromUrl()).into(itemView.ivLogo)

        }


    }



}