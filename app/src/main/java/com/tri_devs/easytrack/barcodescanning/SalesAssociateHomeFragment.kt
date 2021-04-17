package com.tri_devs.easytrack.barcodescanning


import android.content.Intent
import android.os.Bundle
import android.util.Log
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
    val TAG = "SCAN"


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

        Log.d(TAG, "In the oncreate!")
    }

    fun scan(){
        run {
            IntentIntegrator.forSupportFragment(this).initiateScan()
            Log.d(TAG,scannedResult)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var result: IntentResult? = IntentIntegrator.
        parseActivityResult(requestCode, resultCode, data)

        if(result != null){

            if(result.contents != null){
                scannedResult = result.contents
                binding.txtUPC.text = scannedResult
                Log.d(TAG, scannedResult)
            } else {
                binding.txtUPC.text = "scan failed"
                Log.d(TAG, scannedResult)

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
            Log.d(TAG, scannedResult)

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        savedInstanceState?.let {
            scannedResult = it.getString("scannedResult")!!
            binding.txtUPC.text = scannedResult
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.putString("scannedResult", scannedResult)
        super.onSaveInstanceState(outState)
    }


    fun search(){
        findNavController().navigate(R.id.action_salesAssociateHomeFragment_to_seachProductNameFragment)
    }

    fun view(){
        findNavController().navigate(R.id.action_salesAssociateHomeFragment_to_storeInventoryActivity)
    }

}