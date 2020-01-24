package com.example.cryptocurrencykotlin.ui.Fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.cryptocurrencykotlin.R
import com.example.cryptocurrencykotlin.controller.api.Coin
import com.example.cryptocurrencykotlin.controller.CoinAdapter
import com.example.cryptocurrencykotlin.model.MainActivityViewModel
import com.example.cryptocurrencykotlin.ui.DetailActivity

const val COIN = "COIN"


/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private lateinit var viewModel: MainActivityViewModel
    private val coins = arrayListOf<Coin>()
    private val coinAdapter = CoinAdapter(coins){ coin -> startDetailActivity(coin)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_list, container, false)
        val rv = rootView.findViewById(R.id.rvCoins) as RecyclerView
        rv.layoutManager = (LinearLayoutManager(activity))
        rv.adapter = coinAdapter
        rv.itemAnimator = DefaultItemAnimator()

        initViewModel()
        viewModel.getCoinList()

        return rootView
    }


    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.coins.observe(this, Observer {
            coins.clear()
            coins.addAll(it)
            coinAdapter.notifyDataSetChanged()
        })
    }

    private fun startDetailActivity(coin: Coin) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(COIN, coin)
        startActivity(intent)

    }


}
