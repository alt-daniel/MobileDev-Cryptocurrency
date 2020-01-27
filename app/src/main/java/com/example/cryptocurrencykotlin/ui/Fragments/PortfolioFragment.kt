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
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrencykotlin.R
import com.example.cryptocurrencykotlin.controller.listingsApi.PortfolioAdapter
import com.example.cryptocurrencykotlin.controller.data.CoinData
import com.example.cryptocurrencykotlin.model.AddActivityViewModel
import com.example.cryptocurrencykotlin.ui.AddActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_portfolio.*
import kotlinx.android.synthetic.main.fragment_portfolio.view.*


/**
 * A simple [Fragment] subclass.
 */
class PortfolioFragment : Fragment() {
//    private lateinit var viewModel: MainActivityViewModel
    private val coins = arrayListOf<CoinData>()
    private val portfolioAdapter= PortfolioAdapter(coins)
    private lateinit var viewmodel: AddActivityViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        val rootView =  inflater.inflate(R.layout.fragment_portfolio, container, false)
        val rv = rootView.findViewById(R.id.rvPortfolio) as RecyclerView
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = portfolioAdapter
        rv.itemAnimator = DefaultItemAnimator()

        initViewModel()
        createItemTouchHelper().attachToRecyclerView(rv)

        rootView.btnSave.setOnClickListener{startAddActivity()}

        return rootView
    }

    private fun initViewModel() {
        viewmodel = ViewModelProviders.of(this).get(AddActivityViewModel::class.java)

        // Observe reminders from the view model, update the list when the data is changed.
        viewmodel.coins.observe(this, Observer { coins ->
            this@PortfolioFragment.coins.clear()
            this@PortfolioFragment.coins.addAll(coins)
            portfolioAdapter.notifyDataSetChanged()
        })
    }


    private fun startAddActivity() {
        val intent = Intent(activity, AddActivity::class.java)
        startActivity(intent)
    }

    private fun createItemTouchHelper() : ItemTouchHelper {
        //Creates TouchHelper object for swiping to the left.
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            //Disabled ability to move item up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false;
            }


            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val coinToDelete = coins[position]

                viewmodel.deleteCoin(coinToDelete)
                Snackbar.make(rvPortfolio, "${coinToDelete.name} is deleted from your portfolio", 5000)
                    .show()
            }
        }

        return ItemTouchHelper(callback)
    }

}
