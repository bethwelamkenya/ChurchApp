package com.bethwelamkenya.churchapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.bethwelamkenya.churchapp.R
import com.bethwelamkenya.churchapp.databinding.ActivityMemberHomeBinding
import com.bethwelamkenya.churchapp.model.Member
import kotlin.system.exitProcess

class MemberHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemberHomeBinding
    private lateinit var navController: NavController
    private lateinit var navigationHostFragment: NavHostFragment
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var member: ArrayList<Member>
    private var memberName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemberHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        member = intent.getSerializableExtra("member") as ArrayList<Member>
        memberName = intent.getStringExtra("member").toString()
        setSupportActionBar(binding.toolbar)
        toggle = ActionBarDrawerToggle(this, binding.mainContainer, R.string.open, R.string.close)
        binding.mainContainer.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navigationHostFragment.navController
        setupActionBarWithNavController(navController, binding.mainContainer)
    }

    private fun navigateToHome() {
        when (navController.currentDestination?.id){
            R.id.memberHomeFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_memberHomeFragment_self)
            }
            R.id.memberAccountFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_memberAccountFragment_to_memberHomeFragment)
            }
            R.id.memberAttendancesFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_memberAttendancesFragment_to_memberHomeFragment)
            }
        }
    }

    private fun navigateToAccount() {
        when (navController.currentDestination?.id){
            R.id.memberHomeFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_memberHomeFragment_to_memberAccountFragment)
            }
            R.id.memberAccountFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_memberAccountFragment_self)
            }
            R.id.memberAttendancesFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_memberAttendancesFragment_to_memberAccountFragment)
            }
        }
    }

    private fun navigateAttendances() {
        when (navController.currentDestination?.id){
            R.id.memberHomeFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_memberHomeFragment_to_memberAttendancesFragment)
            }
            R.id.memberAccountFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_memberAccountFragment_to_memberAttendancesFragment)
            }
            R.id.memberAttendancesFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_memberAttendancesFragment_self)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu_member_view, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.memberHome -> {
                navigateToHome()
            }
            R.id.memberAccount -> {
                navigateToAccount()
            }
            R.id.memberAttendance -> {
                navigateAttendances()
            }
            R.id.logOut -> {
                startActivity(Intent(this, MainActivity::class.java))
                this.finish()
            }
            R.id.exit -> {
                exitProcess(0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}