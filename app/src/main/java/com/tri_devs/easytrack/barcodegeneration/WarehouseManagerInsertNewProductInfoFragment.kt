package com.tri_devs.easytrack.barcodegeneration

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.FragmentWarehouseManagerInsertNewProductInfoBinding

class WarehouseManagerInsertNewProductInfoFragment : Fragment() {
    lateinit var binding: FragmentWarehouseManagerInsertNewProductInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWarehouseManagerInsertNewProductInfoBinding.inflate(
            this.layoutInflater, container, false)

        binding.btnSubmit.setOnClickListener { submit() }

        return binding.root
    }

    fun submit(){
        findNavController().navigate(
            R.id.action_warehouseManagerInsertNewProductInfoFragment_to_warehouseManagerConfirmInsertFragment)
    }

}