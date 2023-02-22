package com.bethwelamkenya.churchapp.fragments.admin

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bethwelamkenya.churchapp.R
import com.bethwelamkenya.churchapp.adapters.AdminHomeRecyclerAdapter
import com.bethwelamkenya.churchapp.database.DatabaseAdapter
import com.bethwelamkenya.churchapp.interfaces.MemberOnClick
import com.bethwelamkenya.churchapp.model.Member
import com.bethwelamkenya.churchapp.ui.AdminHomeActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class AllMembersFragment : Fragment() , MemberOnClick{

    private lateinit var addMember: ExtendedFloatingActionButton
//    private val passData = PassData()
    private lateinit var adapter: DatabaseAdapter
    private lateinit var recyclerAdapter: AdminHomeRecyclerAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adminHomeActivity: Activity
    private lateinit var members: ArrayList<Member>
//    private var passNote: PassNote? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_members, container, false)
        adminHomeActivity = AdminHomeActivity()
        adapter = DatabaseAdapter(this.requireContext())
//        passNote = this.requireContext() as PassNote
        members = adapter.getMembers()
        recyclerView = view.findViewById(R.id.recyclerViewAllMembers)
        addMember = view.findViewById(R.id.addMemberButton)
        recyclerView.setHasFixedSize(true)
        recyclerAdapter = AdminHomeRecyclerAdapter(this.requireContext(), members, this)
        recyclerView.layoutManager = StaggeredGridLayoutManager(1, LinearLayout.VERTICAL)
        recyclerView.adapter = recyclerAdapter
        addMember.setOnClickListener { findNavController().navigate(R.id.action_allMembersFragment_to_addMemberFragment) }
        return view
    }

    override fun onMemberClicked(member: Member) {
        findNavController().navigate(R.id.action_allMembersFragment_to_editMemberFragment)
    }

    override fun onMemberLonClicked(member: Member, cardView: CardView) {
    }

}