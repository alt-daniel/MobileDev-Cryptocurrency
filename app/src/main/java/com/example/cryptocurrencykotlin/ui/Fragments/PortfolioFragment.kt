package com.example.cryptocurrencykotlin.ui.Fragments



import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cryptocurrencykotlin.R
import com.example.cryptocurrencykotlin.controller.api.Coin
import com.example.cryptocurrencykotlin.controller.data.CoinRoomRepository
import com.example.cryptocurrencykotlin.ui.AddActivity
import kotlinx.android.synthetic.main.fragment_portfolio.view.*


/**
 * A simple [Fragment] subclass.
 */
class PortfolioFragment : Fragment() {
//    private lateinit var viewModel: MainActivityViewModel
    private val coins = arrayListOf<Coin>()


    private lateinit var coinRoomRepository: CoinRoomRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        coinRoomRepository = CoinRoomRepository(requireContext())
        getCoinsFromRepository()
        val rootView =  inflater.inflate(R.layout.fragment_portfolio, container, false)
        rootView.btnSave.setOnClickListener{startAddActivity()}


//        viewModel.getCoinList()
        return rootView
    }

    private fun getCoinsFromRepository() {
        val coinList = coinRoomRepository.getAllCoins()
    }



    private fun startAddActivity() {
        val intent = Intent(activity, AddActivity::class.java)
        startActivity(intent)
    }

}
