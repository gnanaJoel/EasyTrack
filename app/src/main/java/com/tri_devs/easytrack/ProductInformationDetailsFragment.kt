package com.tri_devs.easytrack

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.navArgs
import com.tri_devs.easytrack.databinding.FragmentProductInformationDetailsBinding
import com.tri_devs.easytrack.productInfoUpdate.DepartmentManagerHomeActivity

class ProductInformationDetailsFragment : Fragment() {
    lateinit var binding: FragmentProductInformationDetailsBinding
    val args: ProductInformationDetailsFragmentArgs by navArgs()

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
        binding.btnBack.setOnClickListener { backToMenu() }

        return binding.root
    }

    private fun searchProductByName() {
        TODO("Not yet implemented")
    }

    private fun submitUpdate() {
        confirmationDialog()
    }

    private fun backToMenu(){
        val intent = Intent(activity, DepartmentManagerHomeActivity::class.java)
        startActivity(intent)
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