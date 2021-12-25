package com.example.whproduct_with_recycle_view_with_ntent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whproduct_with_recycle_view_with_ntent.adapter.SmartphoneAdapter
import com.example.whproduct_with_recycle_view_with_ntent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activateGridRecyclerView()
    }

    private fun activateGridRecyclerView() {
        binding.gridRecyclerView.adapter = SmartphoneAdapter(applicationContext)
        binding.gridRecyclerView.setHasFixedSize(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}