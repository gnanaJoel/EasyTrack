package com.tri_devs.easytrack.barcodegeneration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.ActivityMainBinding
import com.tri_devs.easytrack.databinding.ActivityWarehouseManagerConfirmInsertBinding

class WarehouseManagerConfirmInsert : AppCompatActivity() {
    lateinit var binding: ActivityWarehouseManagerConfirmInsertBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_warehouse_manager_confirm_insert)

        binding.btnYes.setOnClickListener { yes() }

        binding.btnNo.setOnClickListener { no() }

    }

    fun yes(){
        Toast.makeText(this, "Product Info Successfully saved!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, WarehouseManagerHomeActivity::class.java)
        startActivity(intent)
    }

    fun no(){
        val intent = Intent(this, WarehouseManagerInsertNewProductInfoActivity::class.java)
        startActivity(intent)

    }
}