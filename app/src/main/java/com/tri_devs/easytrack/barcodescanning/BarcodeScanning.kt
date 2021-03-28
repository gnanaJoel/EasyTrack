package com.tri_devs.easytrack.barcodescanning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.ActivityBarcodeScanningBinding

class BarcodeScanning : AppCompatActivity() {

    private lateinit var binding: ActivityBarcodeScanningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_barcode_scanning)
        binding.btnScanThis.setOnClickListener {
            val intent = Intent(this, ProductInfoSearch::class.java)
            startActivity(intent)
        }

    }
}