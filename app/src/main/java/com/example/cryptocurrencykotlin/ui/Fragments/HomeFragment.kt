package com.example.cryptocurrencykotlin.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.cryptocurrencykotlin.R
import com.example.cryptocurrencykotlin.controller.globalMetricsApi.Data
import com.example.cryptocurrencykotlin.model.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class HomeFragment : Fragment() {

    private lateinit var viewModel: MainActivityViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_home, container, false)

        initViewModel()
        viewModel.getGlobalMetrics()


        return rootview
    }


    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.data.observe(this, Observer {

            val btc = it?.btc_dominance
            val btcTwoDigits = String.format("%.2f", btc)
            val eth = it?.eth_dominance
            val ethTwoDigits = String.format("%.2f", eth)

            tvBtcPercentage.text = btcTwoDigits + " %"
            tvEthPercentage.text = ethTwoDigits + " %"
            tvTotalVolume.text = it?.quote?.uSD?.total_volume_24h.toString()
            tvTotalMarketCap.text = it?.quote?.uSD?.total_market_cap.toString()

        })
    }

}
