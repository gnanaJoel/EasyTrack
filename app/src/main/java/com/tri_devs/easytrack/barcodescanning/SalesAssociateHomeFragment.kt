package com.tri_devs.easytrack.barcodescanning


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.FragmentSalesAssociateHomeBinding



class SalesAssociateHomeFragment : Fragment() {
    lateinit var binding: FragmentSalesAssociateHomeBinding
    var scannedResult: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSalesAssociateHomeBinding.inflate(this.layoutInflater, container, false)

        binding.btnScan.setOnClickListener { scan() }

        binding.btnSearch.setOnClickListener { search() }

        binding.btnView.setOnClickListener { view() }

        binding.btnLogout.setOnClickListener {
            findNavController().navigate(R.id.action_logout_sales)
        }

        return binding.root
    }

    fun scan(){
        run {
            IntentIntegrator(activity).setOrientationLocked(false).initiateScan();
        }

////        val scan = "salesScan"
//        val action = SalesAssociateHomeFragmentDirections.
//        actionSalesAssociateHomeFragmentToBarcodeScanningFragment(scan)
//        findNavController().navigate(action)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var result: IntentResult? = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if(result != null){

            if(result.contents != null){
                scannedResult = result.contents
                //binding.bndBarcode = scannedResult
                Toast.makeText(activity, scannedResult, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "Failed", Toast.LENGTH_LONG).show()
                // binding.bndBarcode = "scan failed"
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    fun search(){
        findNavController().navigate(R.id.action_salesAssociateHomeFragment_to_seachProductNameFragment)
    }

    fun view(){
        findNavController().navigate(R.id.action_salesAssociateHomeFragment_to_storeInventoryActivity)
    }

}