package com.tri_devs.easytrack.productInfoUpdate

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.ActivityProductInformationDetailsActivtyBinding

class ProductInformationDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductInformationDetailsActivtyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_product_information_details_activty
        )

        var bundle:String = intent.getStringExtra("inputType").toString()

        if(bundle == "name"){
            binding.etProductName.text.clear()
            binding.etProductName.inputType = InputType.TYPE_CLASS_TEXT
        }else{
            binding.etProductName.isClickable = false
            binding.etProductName.inputType = InputType.TYPE_NULL
        }

        binding.btnSearchByName.setOnClickListener { searchProductByName() }
        binding.btnSubmit.setOnClickListener {  submitUpdate() }
        binding.btnBack.setOnClickListener { backToMenu() }
    }

    private fun searchProductByName() {
        TODO("Not yet implemented")
    }

    private fun submitUpdate() {
        confirmationDialog()
    }

    private fun backToMenu(){
        val intent = Intent(this, DepartmentManagerHomeActivity::class.java)
        startActivity(intent)
    }

    private fun confirmationDialog(){
        val dialogBuilder = AlertDialog.Builder(this)

        // set message of alert dialog
        dialogBuilder.setMessage("Are you sure you want to update?")
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("Confirm") { _, _ ->
                finish()
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