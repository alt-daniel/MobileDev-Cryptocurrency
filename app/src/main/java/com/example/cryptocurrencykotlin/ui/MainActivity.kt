package com.example.cryptocurrencykotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.cryptocurrencykotlin.R
import com.example.cryptocurrencykotlin.model.MainActivityViewModel

import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
//        supportActionBar?.hide()
        initNavigation()

    }

    private fun initNavigation() {
        // The Navcontroller
        val navController = findNavController(R.id.navHostFragment)

        // Connect the navHostFragment with the BottomNavigationView.
        NavigationUI.setupWithNavController(navView, navController)

        // Connect the navHostFragment with the Toolbar.
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }




}
