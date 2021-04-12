package com.tri_devs.easytrack.barcodegeneration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.FragmentWarehouseManagerConfirmInsertBinding

class WarehouseManagerConfirmInsertFragment : Fragment() {
    lateinit var binding: FragmentWarehouseManagerConfirmInsertBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWarehouseManagerConfirmInsertBinding.inflate(
            this.layoutInflater, container, false
        )

        binding.btnYes.setOnClickListener { yes() }

        binding.btnNo.setOnClickListener { no() }

        return binding.root
    }

    fun yes(){
        Toast.makeText(activity, "Product Info Successfully saved!", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_yes)
    }

    fun no(){
        findNavController().navigate(R.id.action_no)
    }
}