package com.tri_devs.easytrack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tri_devs.easytrack.databinding.ActivityProductInformationDetailsActivtyBinding

class ProductInformationDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductInformationDetailsActivtyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_information_details_activty)

        binding.btnSearchByName.setOnClickListener { searchProductByName() }
        binding.btnSubmit.setOnClickListener {  submitUpdate() }
        binding.btnBack.setOnClickListener { backToMenu() }
    }

    private fun searchProductByName() {
        TODO("Not yet implemented")
    }

    private fun submitUpdate() {
        TODO("Not yet implemented")
    }

    private fun backToMenu(){
        val intent = Intent(this, DepartmentManagerHomeActivity::class.java)
        startActivity(intent)
    }
}