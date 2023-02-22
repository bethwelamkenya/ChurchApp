package com.bethwelamkenya.churchapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.bethwelamkenya.churchapp.R
import com.bethwelamkenya.churchapp.databinding.ActivityAdminHomeBinding
import kotlin.system.exitProcess

class AdminHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminHomeBinding
    private lateinit var navController: NavController
    private lateinit var navigationHostFragment: NavHostFragment
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
            R.id.homeFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_homeFragment_self2)
            }
            R.id.allMembersFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allMembersFragment_to_homeFragment)
            }
            R.id.allAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allAttendanceFragment_to_homeFragment)
            }
            R.id.specificAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_specificAttendanceFragment_to_homeFragment)
            }
            R.id.myAccountFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_myAccountFragment_to_homeFragment)
            }
            R.id.addMemberFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_addMemberFragment_to_homeFragment)
            }
            R.id.editMemberFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_editMemberFragment_to_homeFragment)
            }
        }
    }

    private fun navigateToAllMembers(){
        when (navController.currentDestination?.id){
            R.id.homeFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_homeFragment_to_allMembersFragment)
            }
            R.id.allMembersFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allMembersFragment_self)
            }
            R.id.allAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allAttendanceFragment_to_allMembersFragment)
            }
            R.id.specificAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_specificAttendanceFragment_to_allMembersFragment)
            }
            R.id.myAccountFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_myAccountFragment_to_allMembersFragment)
            }
            R.id.addMemberFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_addMemberFragment_to_allMembersFragment)
            }
            R.id.editMemberFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_editMemberFragment_to_allMembersFragment)
            }
        }
    }

    private fun navigateAllAttendances(){
        when (navController.currentDestination?.id){
            R.id.homeFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_homeFragment_to_allAttendanceFragment)
            }
            R.id.allMembersFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allMembersFragment_to_allAttendanceFragment)
            }
            R.id.allAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allAttendanceFragment_self)
            }
            R.id.specificAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_specificAttendanceFragment_to_allAttendanceFragment)
            }
            R.id.myAccountFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_myAccountFragment_to_allAttendanceFragment)
            }
            R.id.addMemberFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_addMemberFragment_to_allAttendanceFragment)
            }
            R.id.editMemberFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_editMemberFragment_to_allAttendanceFragment)
            }
        }
    }

    private fun navigateToSpecificAttendances(){
        when (navController.currentDestination?.id){
            R.id.homeFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_homeFragment_to_specificAttendanceFragment)
            }
            R.id.allMembersFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allMembersFragment_to_specificAttendanceFragment)
            }
            R.id.allAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allAttendanceFragment_to_specificAttendanceFragment)
            }
            R.id.specificAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_specificAttendanceFragment_self)
            }
            R.id.myAccountFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_myAccountFragment_to_specificAttendanceFragment)
            }
            R.id.addMemberFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_addMemberFragment_to_specificAttendanceFragment)
            }
            R.id.editMemberFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_editMemberFragment_to_specificAttendanceFragment)
            }
        }
    }

    private fun navigateToMyAccount(){
        when (navController.currentDestination?.id){
            R.id.homeFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_homeFragment_to_myAccountFragment)
            }
            R.id.allMembersFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allMembersFragment_to_myAccountFragment)
            }
            R.id.allAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allAttendanceFragment_to_myAccountFragment)
            }
            R.id.specificAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_specificAttendanceFragment_to_myAccountFragment)
            }
            R.id.myAccountFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_myAccountFragment_self)
            }
            R.id.addMemberFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_addMemberFragment_to_myAccountFragment)
            }
            R.id.editMemberFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_editMemberFragment_to_myAccountFragment)
            }
        }
    }

    private fun navigateToAddMember(){
        when (navController.currentDestination?.id){
            R.id.homeFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_homeFragment_to_addMemberFragment)
            }
            R.id.allMembersFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allMembersFragment_to_addMemberFragment)
            }
            R.id.allAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_allAttendanceFragment_to_addMemberFragment)
            }
            R.id.specificAttendanceFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_specificAttendanceFragment_to_addMemberFragment)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu_view, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_bar_search -> {
                navigateToAllMembers()
            }
            R.id.homeFrag -> {
                navigateToHome()
            }
            R.id.allMembers -> {
                navigateToAllMembers()
            }
            R.id.attendance -> {
                navigateAllAttendances()
            }
            R.id.specific -> {
                navigateToSpecificAttendances()
            }
            R.id.myAccount -> {
                navigateToMyAccount()
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