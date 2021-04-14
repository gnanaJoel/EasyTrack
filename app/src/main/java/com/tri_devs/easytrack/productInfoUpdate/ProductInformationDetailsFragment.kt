package com.tri_devs.easytrack.productInfoUpdate

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
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
        }else{
            binding.etProductName.isClickable = false
            binding.etProductName.inputType = InputType.TYPE_NULL
        }

        binding.btnSearchByName.setOnClickListener { searchProductByName() }
        binding.btnSubmit.setOnClickListener {  submitUpdate() }

        //db part
        val query = productsRef.whereEqualTo("upcNumber","91827364598")
        query.get().addOnSuccessListener { documents ->
            for (document in documents) {
                Log.d(TAG, "${document.id} => ${document.data}")
            }
        }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }

        return binding.root
    }

    private fun searchProductByName() {
        TODO("Not yet implemented")
    }

    private fun submitUpdate() {
        confirmationDialog()
    }


    private fun confirmationDialog(){
        val dialogBuilder = AlertDialog.Builder(requireActivity())

        // set message of alert dialog
        dialogBuilder.setMessage("Are you sure you want to update?")
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("Confirm") { dialog, _ ->
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