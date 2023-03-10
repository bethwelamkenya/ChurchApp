package com.bethwelamkenya.churchapp.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.bethwelamkenya.churchapp.R

class HomeFragment : Fragment() {
    private lateinit var allMembersButton: Button
    private lateinit var allAttendancesButton: Button
    private lateinit var specificAttendancesButton: Button
    private lateinit var myAccountButton: Button
    private lateinit var addMember: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        allMembersButton = view.findViewById(R.id.allMembersButton)
        allAttendancesButton = view.findViewById(R.id.allAttendancesButton)
        specificAttendancesButton = view.findViewById(R.id.specificAttendancesButton)
        myAccountButton = view.findViewById(R.id.myAccountButton)
        addMember = view.findViewById(R.id.addMemberButon)
        allMembersButton.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_allMembersFragment) }
        allAttendancesButton.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_allAttendanceFragment) }
        specificAttendancesButton.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_specificAttendanceFragment) }
        myAccountButton.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_myAccountFragment) }
        addMember.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_addMemberFragment) }
        return view
    }

}