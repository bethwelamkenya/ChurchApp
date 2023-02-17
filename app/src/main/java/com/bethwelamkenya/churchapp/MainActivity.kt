package com.bethwelamkenya.churchapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bethwelamkenya.churchapp.databinding.ActivityMainBinding
import com.bethwelamkenya.churchapp.ui.AdminHomeActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.logIn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    AdminHomeActivity::class.java
                )
            )
        }
    }
}