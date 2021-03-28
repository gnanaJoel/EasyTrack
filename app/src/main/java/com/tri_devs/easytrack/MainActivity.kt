package com.tri_devs.easytrack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.tri_devs.easytrack.barcodescanning.SalesAssociateHome
import com.tri_devs.easytrack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var username: String = ""
    var password: String = ""
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setup binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnLogin.setOnClickListener {
            login()
        }
    }


    fun login(){
        username = binding.edtUser.text.toString()
        password = binding.edtPass.text.toString()
        if(username.isEmpty()||password.isEmpty() ){
            Toast.makeText(this, "Please fill in both text input fields", Toast.LENGTH_SHORT).show()
        }

        else{
//            if(username == "Ware100" && password == "ware100"){
//
//            }
             if(username == "Sales100" && password == "sales100"){
                val intent = Intent(this, SalesAssociateHome::class.java)
                startActivity(intent)
            }
//            else if(username == "Dept100" && password == "dept100"){
//
//            }

            else{
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()

            }

        }

    }
}