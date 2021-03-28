package com.tri_devs.easytrack.barcodegeneration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.ActivityWarehouseManagerHomeBinding

class WarehouseManagerHomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityWarehouseManagerHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warehouse_manager_home)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_warehouse_manager_home)

        binding.btnInsertNewProductInfo.setOnClickListener {
            val intent = Intent(this, WarehouseManagerInsertNewProductInfoActivity::class.java)
            startActivity(intent)
        }
    }
}