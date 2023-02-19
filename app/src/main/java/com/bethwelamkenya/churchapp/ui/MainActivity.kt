package com.bethwelamkenya.churchapp.ui

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.InputDevice
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bethwelamkenya.churchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.logIn.isEnabled = false
//        binding.userName.setOnEditorActionListener { v, actionId, event ->
//            if (event.isFromSource(InputDevice.SOURCE_KEYBOARD)){
//                validateDetails()
//            }
//            return@setOnEditorActionListener true
//        }
//        binding.password.setOnEditorActionListener { v, actionId, event ->
//            if (event.isFromSource(InputDevice.SOURCE_KEYBOARD)){
//                validateDetails()
//            }
//            return@setOnEditorActionListener true
//        }
//        binding.accounts.setOnClickListener { validateDetails() }
//        binding.accounts.setOnItemClickListener { parent, view, position, id -> validateDetails() }
        binding.logIn.setOnClickListener { startLogIn() }
        binding.seePassword.setOnClickListener {
            if (binding.password.inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD){
                binding.password.inputType = InputType.TYPE_CLASS_TEXT
            } else{
                binding.password.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
        binding.resetPassword.setOnClickListener{ Toast.makeText(this, "Not Yet Implemented", Toast.LENGTH_SHORT).show()}
    }

    private fun validateDetails(){
        if (binding.accounts.selectedItemPosition == 1){
            binding.logIn.isEnabled =
                !(binding.userName.text.isEmpty() || binding.password.text.isEmpty())
        } else{
            binding.logIn.isEnabled = binding.userName.text.isNotEmpty()
        }
    }

    private fun startLogIn() {
        when(binding.accounts.selectedItemPosition){
            0 -> {
                Toast.makeText(this, "Not Yet Implemented", Toast.LENGTH_SHORT).show()
            }
            1 -> {
                Toast.makeText(this, "Not Yet Implemented", Toast.LENGTH_SHORT).show()
            }
            else -> {
                if (binding.userName.text.equals("bethu") && binding.password.text.equals("9852")){
                    startActivity(
                        Intent(
                            this,
                            AdminHomeActivity::class.java
                        )
                    )
                } else {
                    startActivity(
                        Intent(
                            this,
                            AdminHomeActivity::class.java
                        )
                    )
                    Toast.makeText(this, "Error Somewhere", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}