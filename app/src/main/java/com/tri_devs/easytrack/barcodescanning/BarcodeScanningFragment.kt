package com.tri_devs.easytrack.barcodescanning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.FragmentBarcodeScanningBinding

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
                findNavController().navigate(R.id.action_barcodeScanningFragment_to_productInfoSearchFragment)
            }
            if(scan == "deptScan"){
                val input = "scan"
                val upcNumber = "32165409812"
                val action = BarcodeScanningFragmentDirections.
                actionBarcodeScanningFragmentToProductInformationDetailsFragment(input, upcNumber)
                findNavController().navigate(action)
            }
        }

        return binding.root
    }

}