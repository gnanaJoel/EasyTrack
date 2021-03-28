package com.tri_devs.easytrack.barcodescanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.ActivityBarcodeScanningBinding
import com.tri_devs.easytrack.productInfoUpdate.ProductInformationDetailsActivity

class BarcodeScanning : AppCompatActivity() {

    private lateinit var binding: ActivityBarcodeScanningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_barcode_scanning)
        val bundle:String = intent.getStringExtra("inputType").toString()
        binding.btnScanThis.setOnClickListener {

            if(bundle == "salesScan") {
                val intent = Intent(this, ProductInfoSearch::class.java)
                startActivity(intent)
            }
            if(bundle == "deptScan"){
                val intent = Intent(this, ProductInformationDetailsActivity::class.java)
                intent.putExtra("inputType","scan")
                startActivity(intent)
            }
        }

    }
}