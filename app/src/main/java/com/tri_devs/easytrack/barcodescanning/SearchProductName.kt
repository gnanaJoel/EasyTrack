package com.tri_devs.easytrack.barcodescanning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.ActivitySearchProductNameBinding

class SearchProductName : AppCompatActivity() {

    private lateinit var binding:ActivitySearchProductNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_product_name)

        binding.btnSearchName.setOnClickListener {
            if(binding.edtProductName.text.isNullOrBlank()){
                Toast.makeText(this, "Product Name must be filled", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Product successfully searched", Toast.LENGTH_SHORT).show()
            }
        }
    }
}