package com.tri_devs.easytrack.barcodescanning

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.ActivityMainBinding
import com.tri_devs.easytrack.databinding.ActivitySalesAssociateHomeBinding

class SalesAssociateHome : AppCompatActivity() {
    lateinit var binding: ActivitySalesAssociateHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setup binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sales_associate_home)

        binding.btnScan.setOnClickListener { scan() }

        binding.btnSearch.setOnClickListener { search() }

        binding.btnView.setOnClickListener { view() }
    }

    fun scan(){
        val intent = Intent(this, BarcodeScanning::class.java)
        intent.putExtra("inputType","salesScan")
        startActivity(intent)

    }

    fun search(){
        val intent = Intent(this, SearchProductName::class.java)
        startActivity(intent)

    }

    fun view(){
        val intent = Intent(this, SalesAssociateHome::class.java)
        startActivity(intent)

    }




}