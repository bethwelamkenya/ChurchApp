package com.bethwelamkenya.churchapp.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.bethwelamkenya.churchapp.R
import com.bethwelamkenya.churchapp.ui.AdminHomeActivity

class AllMembersFragment : Fragment() {
    private lateinit var back: ImageButton
    private lateinit var adminHomeActivity: AdminHomeActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_members, container, false)
        adminHomeActivity = AdminHomeActivity()
        back = view.findViewById(R.id.back)
//        back.setOnClickListener { adminHomeActivity.onBackPressed() }
        return view
    }

}