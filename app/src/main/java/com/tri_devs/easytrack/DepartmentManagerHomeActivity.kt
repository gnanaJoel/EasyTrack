package com.tri_devs.easytrack


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
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

    private fun searchProductScan(){ }
    private fun searchProductName(){ }
    private fun viewAllProducts() { }
}