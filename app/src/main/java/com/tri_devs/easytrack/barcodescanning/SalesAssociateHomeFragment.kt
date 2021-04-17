package com.tri_devs.easytrack.barcodescanning
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.tri_devs.easytrack.R
import com.tri_devs.easytrack.databinding.FragmentSalesAssociateHomeBinding
import com.tri_devs.easytrack.entities.Product

class SalesAssociateHomeFragment : Fragment() {
    lateinit var binding: FragmentSalesAssociateHomeBinding
    var scannedResult: String = ""
    val TAG = "BARSCAN"
    val db = Firebase.firestore
    val productsRef = db.collection("products")
    //lateinit var productInfo: Product


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSalesAssociateHomeBinding.inflate(this.layoutInflater, container, false)

        binding.btnScan.setOnClickListener { scan() }

        binding.btnSearch.setOnClickListener { search() }

        binding.btnView.setOnClickListener { view() }

        binding.btnLogout.setOnClickListener {
            findNavController().navigate(R.id.action_logout_sales)
        }

        return binding.root

//        Log.d(TAG, "In the oncreate!")
    }

    fun search() {
        findNavController().navigate(R.id.action_salesAssociateHomeFragment_to_seachProductNameFragment)
    }

    fun view() {
        findNavController().navigate(R.id.action_salesAssociateHomeFragment_to_storeInventoryActivity)
    }


    fun scan() {
        run {
            IntentIntegrator.forSupportFragment(this).initiateScan()
//            Log.d(TAG, scannedResult)
        }
        getsingleProduct()
//        Toast.makeText(activity, scannedResult, Toast.LENGTH_SHORT).show()


//        if (scannedResult.isNotEmpty()){
//            //getProduct()
//        }
//        else{
//            Toast.makeText(activity, "Invalid UPC Number", Toast.LENGTH_SHORT).show()
//        }
    }

    fun getsingleProduct(){
        productsRef
            .whereEqualTo("upcNumber", scannedResult)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    //Toast.makeText(activity, document.toString(), Toast.LENGTH_SHORT).show()
                    //document.get("name").toString()
                    binding.txtDoc.text = document.get("name").toString()

                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }

    }

//    fun getsingleProduct(){
//       // scannedResult.val
//        val docRef = productsRef.document(scannedResult)
//        docRef.get()
//            .addOnSuccessListener { document ->
//                if (document != null) {
//                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
//                    Toast.makeText(activity, "UPC number exists", Toast.LENGTH_SHORT).show()
//                } else {
//                    Log.d(TAG, "No such document")
//                    Toast.makeText(activity, "UPC number doesn't exist", Toast.LENGTH_SHORT).show()
//
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.d(TAG, "Unknown error ", exception)
//                Toast.makeText(activity, "Unknown error", Toast.LENGTH_SHORT).show()
//
//            }
//
//    }

    fun getProduct(){
        val query = productsRef.whereEqualTo("upcNumber", scannedResult)
        query.get().addOnSuccessListener { documents ->
            for (document in documents) {
                if (document != null) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    val productInfo = Product(
                        document.get("name").toString(),
                        document.get("description").toString(),
                        document.get("quantity").toString().toInt(),
                        document.get("upcNumber").toString().toLong(),
                        document.get("retailPrice").toString(),
                        document.get("salesPrice").toString(),
                        document.get("startSalesDate").toString(),
                        document.get("endSalesDate").toString()
                    )

                    val action = SalesAssociateHomeFragmentDirections.goToProductInfoSearch(productInfo)
                    findNavController().navigate(action)


                } else {
                    Toast.makeText(activity, "Invalid UPC Number", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
                Toast.makeText(activity, "Can't connect to the db", Toast.LENGTH_SHORT)
                    .show()

            }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.putString("scannedResult", scannedResult)
        super.onSaveInstanceState(outState)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var result: IntentResult? =
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {

            if (result.contents != null) {
                scannedResult = result.contents
                binding.txtUPC.text = scannedResult
//                Log.d(TAG, scannedResult)
                //Toast.makeText(activity, scannedResult, Toast.LENGTH_LONG).show()

            }
        }


    }

}