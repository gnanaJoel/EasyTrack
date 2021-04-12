package com.tri_devs.easytrack

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.tri_devs.easytrack.barcodescanning.ProductInfoSearch
import com.tri_devs.easytrack.databinding.FragmentBarcodeScanningBinding
import com.tri_devs.easytrack.productInfoUpdate.ProductInformationDetailsActivity

class BarcodeScanningFragment : Fragment() {
    lateinit var binding: FragmentBarcodeScanningBinding
    val args: BarcodeScanningFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBarcodeScanningBinding.inflate(this.layoutInflater, container, false)

        val scan = args.scan

        binding.btnScanThis.setOnClickListener {
            if(scan == "salesScan") {
//                val intent = Intent(this, ProductInfoSearch::class.java)
//                startActivity(intent)
            }
            if(scan == "deptScan"){
//                val intent = Intent(this, ProductInformationDetailsActivity::class.java)
//                intent.putExtra("inputType","scan")
//                startActivity(intent)
            }
        }

        return binding.root
    }

}