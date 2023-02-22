package com.bethwelamkenya.churchapp.fragments.admin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bethwelamkenya.churchapp.R
import com.bethwelamkenya.churchapp.database.DatabaseAdapter
import com.bethwelamkenya.churchapp.model.Member
import com.bethwelamkenya.churchapp.ui.AdminHomeActivity

class AddMemberFragment : Fragment() {
    private lateinit var cancel: Button
    private lateinit var addAdmin: Button
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var regNo: EditText
    private lateinit var number: EditText
    private lateinit var school: Spinner
    private lateinit var year: Spinner
    private lateinit var department: Spinner
    private lateinit var residence: EditText
    private lateinit var adminHomeActivity: AdminHomeActivity
    private lateinit var adapter: DatabaseAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_member, container, false)
        adminHomeActivity = AdminHomeActivity()
        adapter = DatabaseAdapter(view.context)
        cancel = view.findViewById(R.id.cancel)
        addAdmin = view.findViewById(R.id.addNewMember)

        name = view.findViewById(R.id.name)
        email = view.findViewById(R.id.email)
        regNo = view.findViewById(R.id.regNo)
        number = view.findViewById(R.id.number)
        school = view.findViewById(R.id.school)
        year = view.findViewById(R.id.year)
        department = view.findViewById(R.id.department)
        residence = view.findViewById(R.id.residence)
//        addAdmin.isEnabled = false
//        back.setOnClickListener { adminHomeActivity.onBackPressed() }
        addAdmin.setOnClickListener { insertMember(view) }
        return view
    }

    private fun insertMember(view: View) {
        val member = Member(
            name.text.toString(),
            email.text.toString(),
            regNo.text.toString(),
            number.text.toString().toLong(),
            school.selectedItem.toString(),
            year.selectedItemPosition,
            department.selectedItem.toString(),
            residence.text.toString())
        if (adapter.getMember(name.text.toString()).size == 0){
            if (adapter.insertMember(member).toInt() != -0) {
                Toast.makeText(view.context, "Member Inserted Successfully", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addMemberFragment_to_allMembersFragment)
            } else {
                Toast.makeText(view.context, "Could Not Insert Member", Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(view.context, "Member Already Exists", Toast.LENGTH_SHORT).show()
        }
    }
}