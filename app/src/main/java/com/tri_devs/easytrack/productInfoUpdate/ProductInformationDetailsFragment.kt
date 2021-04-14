package com.tri_devs.easytrack.productInfoUpdate

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.FragmentProductInformationDetailsBinding

class ProductInformationDetailsFragment : Fragment() {
    lateinit var binding: FragmentProductInformationDetailsBinding
    val args: ProductInformationDetailsFragmentArgs by navArgs()
    val db = Firebase.firestore
    val productsRef = db.collection("products")
    val TAG = "Prod Info Details"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductInformationDetailsBinding.inflate(this.layoutInflater, container, false)

        val input = args.input

        if(input == "name"){
            binding.etProductName.text.clear()
            binding.etProductName.inputType = InputType.TYPE_CLASS_TEXT
            binding.tvUPC.text = ""
        }else{
            binding.etProductName.isClickable = false
            binding.etProductName.inputType = InputType.TYPE_NULL

            //db part
            val query = productsRef.document("91827364598")
            query.get().addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                    binding.etProductName.setText(document.get("name").toString())
                    binding.etPrice.setText("$"+document.get("price").toString())
                    binding.etSalesPrice.setText("$"+document.get("salesPrice").toString())
                    binding.etDescription.setText(document.get("description").toString())
                    binding.etQuantity.setText(document.get("quantity").toString())
                    binding.tvUPC.text = document.id
                    binding.etBeginSalesDate.setText(document.get("startSalesDate").toString())
                    binding.etEndSalesDate.setText(document.get("endSalesDate").toString())
                    when {
                        document.get("sales").toString().toInt() == 0 -> {
                            binding.rgSalesHolidays.check(binding.rb1.id)
                        }
                        document.get("sales").toString().toInt() == 1 -> {
                            binding.rgSalesHolidays.check(binding.rb2.id)
                        }
                        else -> {
                            binding.rgSalesHolidays.check(binding.rb3.id)
                        }
                    }
                } else {
                    Log.d(TAG, "No such product")
                }
            }
                .addOnFailureListener { exception ->
                    Log.d(TAG, "get failed with ", exception)
                }
        }

        binding.btnSearchByName.setOnClickListener { searchProductByName() }
        binding.btnSubmit.setOnClickListener {  submitUpdate() }


        return binding.root
    }

    private fun searchProductByName() {
        val prodName = binding.etProductName.text
        if (prodName.toString().isNullOrBlank()){
            Toast.makeText(activity, "Please enter a product name", Toast.LENGTH_SHORT).show()
        }
        else{
            val query = productsRef.whereEqualTo("name",prodName.toString())
            query.get().addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    binding.etProductName.setText(document.get("name").toString())
                    binding.etPrice.setText("$"+document.get("price").toString())
                    binding.etSalesPrice.setText("$"+document.get("salesPrice").toString())
                    binding.etDescription.setText(document.get("description").toString())
                    binding.etQuantity.setText(document.get("quantity").toString())
                    binding.tvUPC.text = document.get("upcNumber").toString()
                    binding.etBeginSalesDate.setText(document.get("startSalesDate").toString())
                    binding.etEndSalesDate.setText(document.get("endSalesDate").toString())
                    when {
                        document.get("sales").toString().toInt() == 0 -> {
                            binding.rgSalesHolidays.check(binding.rb1.id)
                        }
                        document.get("sales").toString().toInt() == 1 -> {
                            binding.rgSalesHolidays.check(binding.rb2.id)
                        }
                        else -> {
                            binding.rgSalesHolidays.check(binding.rb3.id)
                        }
                    }
                }
            }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents: ", exception)
                }
        }
    }

    private fun submitUpdate() {
        val upcNumber = binding.tvUPC.text
        if (upcNumber.isNullOrBlank()){
            Toast.makeText(activity, "Needs UPC Number to update", Toast.LENGTH_SHORT).show()
        }
        else{
            confirmationDialog()
        }
    }


    private fun confirmationDialog(){
        val dialogBuilder = AlertDialog.Builder(requireActivity())

        // set message of alert dialog
        dialogBuilder.setMessage("Are you sure you want to update?")
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("Confirm") { dialog, _ ->
                val upcNumber = binding.tvUPC.text

                dialog.dismiss()
            }
            // negative button text and action
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Confirm Update")
        // show alert dialog
        alert.show()
    }

}