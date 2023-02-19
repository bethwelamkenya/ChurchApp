package com.bethwelamkenya.churchapp.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.bethwelamkenya.churchapp.R
import com.bethwelamkenya.churchapp.databinding.ActivityAdminHomeBinding

class AdminHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminHomeBinding
    private lateinit var navController: NavController
    private lateinit var navigationHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        navigationHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navigationHostFragment.navController
//        setupActionBarWithNavController(navController, binding.mainContainer)
//        setupActionBarWithNavController(navController)
        binding.toolbar.setNavigationOnClickListener {
            if (binding.mainContainer.isDrawerOpen(binding.navigationView)){
                binding.mainContainer.openDrawer(binding.navigationView)
            } else{
                binding.mainContainer.closeDrawer(binding.navigationView)
            }
        }
        binding.navigationView.setNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.homeFrag -> {
                    navigateToHome()
                    binding.mainContainer.closeDrawer(binding.navigationView)
                        return@setNavigationItemSelectedListener true
                    }
                R.id.allMembers -> {
                    navigateToAllMembers()
                    binding.mainContainer.closeDrawer(binding.navigationView)
                    return@setNavigationItemSelectedListener true
                }
                R.id.attendance -> {
                    navigateAllAttendances()
                    binding.mainContainer.closeDrawer(binding.navigationView)
                    return@setNavigationItemSelectedListener true
                }
                R.id.specific -> {
                    navigateToSpecificAttendances()
                    binding.mainContainer.closeDrawer(binding.navigationView)
                    return@setNavigationItemSelectedListener true
                }
                R.id.myAccount -> {
                    navigateToMyAccount()
                    binding.mainContainer.closeDrawer(binding.navigationView)
                    return@setNavigationItemSelectedListener true
                }
                else -> {
                    binding.mainContainer.closeDrawer(binding.navigationView)
                    return@setNavigationItemSelectedListener false
                }
            }
        }
        binding.addMember.setOnClickListener { navigateToAddMember() }
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
            R.id.myAccountFragment -> {
                findNavController(R.id.fragmentContainerView).navigate(R.id.action_myAccountFragment_to_addMemberFragment)
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
            androidx.appcompat.R.id.home -> {
            }
            R.id.homeFrag -> {
                navigateToHome()
                Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
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
        }
        return super.onOptionsItemSelected(item)
    }
}