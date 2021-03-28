package com.tri_devs.easytrack.barcodegeneration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.ActivityWarehouseManagerConfirmInsertBinding
import com.tri_devs.easytrack.databinding.ActivityWarehouseManagerInsertNewProductInfoBinding

class WarehouseManagerInsertNewProductInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityWarehouseManagerInsertNewProductInfoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_warehouse_manager_insert_new_product_info)

        binding.btnSubmit.setOnClickListener { submit() }
    }

    fun submit(){
        val intent = Intent(this, WarehouseManagerConfirmInsert::class.java)
        startActivity(intent)
    }


}