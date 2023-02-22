package com.bethwelamkenya.churchapp.ui

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.bethwelamkenya.churchapp.database.DatabaseAdapter
import com.bethwelamkenya.churchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val isVisible = false
    private lateinit var adapter: DatabaseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.logIn.isEnabled = false
        adapter = DatabaseAdapter(this)
        binding.userName.addTextChangedListener { validateDetails() }
        binding.password.addTextChangedListener { validateDetails() }
        binding.logIn.setOnClickListener { startLogIn() }
        binding.seePassword.setOnClickListener {
            isVisible != isVisible
            if (isVisible){
//                binding.password.inputType = InputType.TYPE_CLASS_TEXT
                binding.password.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else{
                println("Password\npassword\npassword")
                binding.password.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
        binding.resetPassword.setOnClickListener{ Toast.makeText(this, "Not Yet Implemented", Toast.LENGTH_SHORT).show()}
    }

    private fun validateDetails(){
        if (binding.accounts.selectedItemPosition == 1){
            binding.logIn.isEnabled = binding.userName.text.toString() != ""
        } else{
            binding.logIn.isEnabled =
                binding.userName.text.toString() != "" && binding.password.text.toString() != ""
        }
    }

    private fun startLogIn() {
        when(binding.accounts.selectedItemPosition){
            0 -> {
                Toast.makeText(this, "Not Yet Implemented", Toast.LENGTH_SHORT).show()
            }
            1 -> {
                if (adapter.getMember(binding.userName.text.toString()).size != 0){
                    val intent = Intent(this, MemberHomeActivity::class.java)
                    intent.putExtra("member", binding.userName.text.toString())
                    startActivity(intent)
//                    startActivity(Intent(this, MemberHomeActivity::class.java))
                    this.finish()
                } else{
                    Toast.makeText(this, "The MemberDoes Not Exist", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                if (binding.userName.text.toString() == "bethu" && binding.password.text.toString() == "9852"){
                    startActivity(
                        Intent(
                            this,
                            AdminHomeActivity::class.java
                        )
                    )
                    this.finish()
                } else {
                    Toast.makeText(this, "Invalid Details Passed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}