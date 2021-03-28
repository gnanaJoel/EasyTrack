package com.tri_devs.easytrack.store_inventory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.adapterviews.StoreInventoryAdapter
import com.tri_devs.easytrack.databinding.ActivityStoreInventoryBinding
import com.tri_devs.easytrack.entities.Product

class StoreInventoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityStoreInventoryBinding

    lateinit var storeProductList : MutableList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_inventory)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_store_inventory)
        binding.rvStoreInventory.layoutManager = LinearLayoutManager(this)

        storeProductList = mutableListOf<Product>()
        storeProductList.add(Product("Lego Star Wars", "Star Wars Lego Set", 15, 9125055325260, getString(R.string.retailPrice), "$79.99", "21Dec16-21Dec31"))
        storeProductList.add(Product("Lego Harry Potter", "Harry Potter Lego Set", 10, 631406983752, "$69.99", "N/A", "N/A"))



        val adapter = StoreInventoryAdapter(storeProductList)
        binding.rvStoreInventory.adapter = adapter

    }
}