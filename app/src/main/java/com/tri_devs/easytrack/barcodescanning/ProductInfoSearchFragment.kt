package com.tri_devs.easytrack.barcodescanning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tri_devs.easytrack.R

class ProductInfoSearchFragment : Fragment() {
    private lateinit var binding: FragmentBattleResultsBinding
    private lateinit var binding: FragmentProductI


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_info_search, container, false)
    }

}