package com.tri_devs.easytrack.barcodescanning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tri_devs.easytrack.databinding.FragmentSearchProductNameBinding

class SearchProductNameFragment : Fragment() {
    lateinit var binding: FragmentSearchProductNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchProductNameBinding.inflate(this.layoutInflater, container, false)

        binding.btnSearchName.setOnClickListener {
            if(binding.edtProductName.text.isNullOrBlank()){
                Toast.makeText(activity, "Product Name must be filled", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(activity, "Product successfully searched", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }


}