package com.tri_devs.easytrack.productInfoUpdate


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.barcodescanning.BarcodeScanning
import com.tri_devs.easytrack.databinding.ActivityDepartmentManagerHomeBinding

class DepartmentManagerHomeActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDepartmentManagerHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_department_manager_home)

        binding.btnSearchProductScan.setOnClickListener { searchProductScan() }
        binding.btnSearchProductName.setOnClickListener { searchProductName()  }
        binding.btnViewAllProducts.setOnClickListener { viewAllProducts() }
    }

    private fun searchProductScan(){
        val intent = Intent(this, BarcodeScanning::class.java)
        intent.putExtra("inputType","deptScan")
        startActivity(intent)
    }
    private fun searchProductName(){
        val intent = Intent(this, ProductInformationDetailsActivity::class.java)
        intent.putExtra("inputType","name")
        startActivity(intent)
    }
    private fun viewAllProducts() { }
}