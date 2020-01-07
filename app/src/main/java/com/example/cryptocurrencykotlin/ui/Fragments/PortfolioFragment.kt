package com.example.cryptocurrencykotlin.ui.Fragments


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.cryptocurrencykotlin.R

/**
 * A simple [Fragment] subclass.
 */
class PortfolioFragment : Fragment() {

    var btn1hClicked: Boolean = false
    var btn24hClicked: Boolean = false
    var btn7dClicked: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_portfolio, container, false)
    }

    private fun initViews() {
//        changeButtonState()
    }

    private fun changeButtonState(button: Button) {
        if (btn1hClicked || btn24hClicked || btn7dClicked) {
            button.setBackgroundColor(Color.parseColor("#00574B"))
        }

    }

}
