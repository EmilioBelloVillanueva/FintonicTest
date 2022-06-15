package com.fintonic.beers.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fintonic.beers.databinding.ActivityMainBinding
import com.fintonic.beers.ui.adapters.BeersAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        init()
    }

    private fun init() {
        findViews()
        observers()
    }

    private fun findViews() {
        val recycler = binding.rvBeers
        val adapter = BeersAdapter(emptyList())

        recycler.adapter = adapter
    }

    private fun observers() {

    }
}