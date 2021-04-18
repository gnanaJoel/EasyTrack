package com.tri_devs.easytrack.barcodegeneration

import android.app.AlertDialog
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.zxing.BarcodeFormat
import com.google.zxing.oned.UPCAWriter
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.CustomProductEntryDialogBinding
import com.tri_devs.easytrack.databinding.FragmentNewProductEntryBinding
import com.tri_devs.easytrack.entities.Product

class NewProductEntryFragment : Fragment() {
    lateinit var productEntryBinding: FragmentNewProductEntryBinding
    lateinit var productEntryDialogBinding: CustomProductEntryDialogBinding
    val db = Firebase.firestore
    val productsRef = db.collection("products")
    val TAG = "Barcode Generation"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        productEntryBinding = FragmentNewProductEntryBinding.inflate(this.layoutInflater, container, false)

        productEntryBinding.btnSubmit.setOnClickListener { submitProductInfo() }

        return productEntryBinding.root
    }





    fun submitProductInfo(){
        productEntryDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this.context), R.layout.custom_product_entry_dialog, null,false)

        val product = Product(name = productEntryBinding.edtName.text.toString(), description = productEntryBinding.edtDescription.text.toString(), quantity = productEntryBinding.edtQuantity.text.toString().toInt(), retailPrice = productEntryBinding.edtRetailPrice.text.toString())

        product.upcNumber = 885909950805

        displayBitmap(product.upcNumber.toString())
        productEntryDialogBinding.bndProduct = product


        val dialog = AlertDialog.Builder(this.context).setView(productEntryDialogBinding.root).setCancelable(false).setPositiveButton("Yes") { dialog, _ ->
            val productEntry = hashMapOf(
                "name" to productEntryDialogBinding.bndProduct!!.name,
                "description" to productEntryDialogBinding.bndProduct!!.description,
                "price" to productEntryDialogBinding.bndProduct!!.retailPrice,
                "quantity" to productEntryDialogBinding.bndProduct!!.quantity,
                "upcNumber" to productEntryDialogBinding.bndProduct!!.upcNumber,
                "sales" to 0,
                "salesPrice" to "",
                "startSalesDate" to "",
                "endSalesDate" to ""
            )

            productsRef.document(productEntryDialogBinding.bndProduct!!.upcNumber.toString())
                .set(productEntry)
                .addOnSuccessListener { Log.d(TAG, "Product Entry successfully written to FireStore DB!") }
                .addOnFailureListener { Log.d(TAG, "Error on writing Product Entry to FireStore DB") }

            findNavController().navigate(R.id.action_yes)

        }.setNegativeButton("No"){ dialog, _ ->
            dialog.dismiss()
        }.create().show()
    }

    private fun createBarcodeBitmap(
        barcodeValue: String,
        barcodeColor: Int,
        backgroundColor: Int,
        widthPixels: Int,
        heightPixels: Int
    ): Bitmap {
        val bitMatrix = UPCAWriter().encode(
            barcodeValue,
            BarcodeFormat.UPC_A,
            widthPixels,
            heightPixels
        )

        val pixels = IntArray(bitMatrix.width * bitMatrix.height)
        for (y in 0 until bitMatrix.height) {
            val offset = y * bitMatrix.width
            for (x in 0 until bitMatrix.width) {
                pixels[offset + x] =
                    if (bitMatrix.get(x, y)) barcodeColor else backgroundColor
            }
        }

        val bitmap = Bitmap.createBitmap(
            bitMatrix.width,
            bitMatrix.height,
            Bitmap.Config.ARGB_8888
        )
        bitmap.setPixels(
            pixels,
            0,
            bitMatrix.width,
            0,
            0,
            bitMatrix.width,
            bitMatrix.height
        )
        return bitmap
    }



    private fun displayBitmap(value: String) {
        val widthPixels = resources.getDimensionPixelSize(R.dimen.width_barcode)
        val heightPixels = resources.getDimensionPixelSize(R.dimen.height_barcode)
            productEntryDialogBinding.imageBarcode.setImageBitmap(
            createBarcodeBitmap(value, ContextCompat.getColor(requireContext(), android.R.color.black), ContextCompat.getColor(requireContext(),android.R.color.white), widthPixels, heightPixels
            )
        )
    }

}