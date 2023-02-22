package com.bethwelamkenya.churchapp.fragments.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import com.bethwelamkenya.churchapp.R
import com.bethwelamkenya.churchapp.database.DatabaseAdapter
import com.bethwelamkenya.churchapp.model.Member
import com.bethwelamkenya.churchapp.ui.AdminHomeActivity

class EditMemberFragment : Fragment() {
    private lateinit var cancel: Button
    private lateinit var editMember: Button
    private lateinit var id: EditText
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
        val view = inflater.inflate(R.layout.fragment_edit_member, container, false)
        adminHomeActivity = AdminHomeActivity()
        adapter = DatabaseAdapter(view.context)
        cancel = view.findViewById(R.id.cancel)
        editMember = view.findViewById(R.id.editMember)

        id = view.findViewById(R.id.id)
        name = view.findViewById(R.id.name)
        email = view.findViewById(R.id.email)
        regNo = view.findViewById(R.id.regNo)
        number = view.findViewById(R.id.number)
        school = view.findViewById(R.id.school)
        year = view.findViewById(R.id.year)
        department = view.findViewById(R.id.department)
        residence = view.findViewById(R.id.residence)
        editMember.isEnabled = false
//        back.setOnClickListener { adminHomeActivity.onBackPressed() }
        editMember.setOnClickListener { editMember() }
        return view
    }

    private fun editMember(){
        val member = Member(
            id.text.toString().toLong(),
            name.text.toString(),
            email.text.toString(),
            regNo.text.toString(),
            number.text.toString().toLong(),
            school.selectedItem.toString(),
            year.selectedItemPosition,
            department.selectedItem.toString(),
            residence.text.toString())
        if (adapter.updateMember(member) == 0) {
            Toast.makeText(adminHomeActivity, "Could Not Update Member", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(adminHomeActivity, "Member Updated Successfully", Toast.LENGTH_SHORT).show()
        }

    }
}