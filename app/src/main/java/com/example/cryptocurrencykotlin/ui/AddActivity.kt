package com.example.cryptocurrencykotlin.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cryptocurrencykotlin.R
import com.example.cryptocurrencykotlin.controller.api.Coin
import com.example.cryptocurrencykotlin.controller.data.CoinData
import com.example.cryptocurrencykotlin.controller.data.CoinRoomRepository
import com.example.cryptocurrencykotlin.model.MainActivityViewModel

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*


class AddActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private val coins = arrayListOf<Coin>()
    private lateinit var coinRoomRepository: CoinRoomRepository



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        initViewModel()
        initViews()
        viewModel.getCoinList()
        println(coins.toString())

        if (spCoin != null) {
            val adapter = ArrayAdapter(this, R.layout.spinner_item, coins)
            spCoin.adapter = adapter
            spCoin.setSelection(1)
            adapter.notifyDataSetChanged()


        }

        spCoin?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                spCoin.setSelection(1)
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(baseContext, "lol", Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun initViews() {
        btnSave.setOnClickListener { getSelectedCoin() }
    }


    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.coins.observe(this, Observer {
            coins.clear()
            coins.addAll(it)

        })
    }

    private fun getSelectedCoin() {
        val coin = spCoin.selectedItem as Coin
        testMessage(coin)
    }

   private fun testMessage(coin: Coin) {
       Toast.makeText(this, "name: " + coin.name, Toast.LENGTH_LONG).show()
    }



}
