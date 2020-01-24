package com.example.cryptocurrencykotlin.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.cryptocurrencykotlin.R
import com.example.cryptocurrencykotlin.controller.api.Coin
import com.example.cryptocurrencykotlin.ui.Fragments.COIN
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
    }

    private fun initViews() {
        val coin: Coin = intent.getParcelableExtra(COIN)

        tvDetailName.text = coin.name
        tvDetailPrice.text = "$ " + coin.quote.usd.price.toString()
        tvDetailRank.text = coin.rank.toString()
        tvDetailMarketCap.text = coin.quote.usd.market_cap.toString()
        tvDetailPortfolio.text = "no"
        tvDetailVolume.text = coin.quote.usd.volume_24h.toString()

        percentageFormatter(coin.quote.usd.percent_change_1h, tvDetail1h)
        percentageFormatter(coin.quote.usd.percent_change_24h, tvDetail24h)
        percentageFormatter(coin.quote.usd.percent_change_7d, tvDetail7d)

        Glide.with(this).load(coin.getLogofromUrl()).into(ivDetailLogo)

    }

    private fun percentageFormatter(number: Double, textView: TextView) {
        if (number > 0) {
            textView.setTextColor(Color.parseColor("#00574B"))
        } else textView.setTextColor(Color.parseColor("#EE0235"))

        var numberFormatted = String.format("%.2f", number)
        textView.text = numberFormatted + " %"
    }
}
