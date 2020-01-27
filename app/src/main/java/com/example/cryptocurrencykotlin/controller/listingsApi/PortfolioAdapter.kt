package com.example.cryptocurrencykotlin.controller.listingsApi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrencykotlin.R
import com.example.cryptocurrencykotlin.controller.data.CoinData
import kotlinx.android.synthetic.main.item_coin_portfolio.view.*

class PortfolioAdapter (private val coinList: List<CoinData>) : RecyclerView.Adapter<PortfolioAdapter.Viewholder>() {
    private lateinit var context: Context

    override fun getItemCount(): Int {
        return coinList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        return Viewholder(
            LayoutInflater.from(context).inflate(R.layout.item_coin_portfolio, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(coinList[position])
    }

    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(coinData: CoinData) {

            itemView.tvPortfolioName.text = coinData.name
            itemView.tvPortfolioAmount.text = coinData.amount.toString()
            itemView.tvPortfolioPrice.text = coinData.price.toString() + " USD"

        }
    }
}