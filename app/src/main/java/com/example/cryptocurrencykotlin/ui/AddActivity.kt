package com.example.cryptocurrencykotlin.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.cryptocurrencykotlin.controller.data.CoinData
import com.example.cryptocurrencykotlin.controller.data.CoinRoomRepository
import android.widget.Toast
import com.example.cryptocurrencykotlin.R
import com.example.cryptocurrencykotlin.model.AddActivityViewModel
import kotlinx.android.synthetic.main.content_add.*

import java.util.*
import kotlin.collections.ArrayList


class AddActivity : AppCompatActivity() {

    private lateinit var viewModel: AddActivityViewModel
    private var coinNames = ArrayList<String>()
    private lateinit var coinRoomRepository: CoinRoomRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        setContentView(R.layout.content_add)

        coinNames = ArrayList<String>(Arrays.asList(*resources.getStringArray(R.array.coins)))
        val spinnerValue: Spinner = findViewById(R.id.spCoin)
        val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_item, coinNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerValue.adapter = adapter
        adapter.notifyDataSetChanged()


        spinnerValue.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {}
        }

        initViews()

    }

    // Initialize button
    private fun initViews() {
        btnSave.setOnClickListener { insertCoin() }
        btnGoBack.setOnClickListener { super.onBackPressed() }
    }

    // Initialize model
    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(AddActivityViewModel::class.java)
    }

    private fun insertCoin() {
        val spinner: Spinner = findViewById(R.id.spCoin)
        val coin = spinner.selectedItem.toString()
        val amount = etAmount.text.toString()
        val price = etPrice.text.toString()
        val id = spinner.selectedItemPosition+1

        if (amount.isNotBlank() && price.isNotBlank()) {


            val insertedCoin = CoinData(coin, id, price.toDouble(), amount.toDouble())
            viewModel.insertCoin(insertedCoin)
            Toast.makeText(this, "You added ${insertedCoin.amount} of ${insertedCoin.name} for a price of: $ ${insertedCoin.price}", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, "One or more fields are empty", Toast.LENGTH_LONG).show()
        }
    }

}
