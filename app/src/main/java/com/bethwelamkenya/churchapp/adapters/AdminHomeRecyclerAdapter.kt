package com.bethwelamkenya.churchapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bethwelamkenya.churchapp.R
import com.bethwelamkenya.churchapp.interfaces.MemberOnClick
import com.bethwelamkenya.churchapp.model.Member
import java.util.*
import kotlin.collections.ArrayList

class AdminHomeRecyclerAdapter(private val context: Context, members: ArrayList<Member>,
                               private val onClick: MemberOnClick) : RecyclerView.Adapter<AdminHomeRecyclerAdapter.AdminHomeRecyclerViewModel>(){

    private val membersList = members
    private val fullList = members
    private var years = arrayOf("Community", "One", "Two", "Three", "Four", "Five")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminHomeRecyclerViewModel {
        return AdminHomeRecyclerViewModel(LayoutInflater.from(context).inflate(R.layout.all_members_design, parent, false))
    }

    override fun onBindViewHolder(holder: AdminHomeRecyclerViewModel, position: Int) {
        val member = membersList[position]
        holder.memberID.text = member.id.toString()
        holder.memberName.text = member.name
        holder.memberEmail.text = member.email
        holder.memberNumber.text = member.number.toString()
        holder.memberRegNo.text = member.regNo
        holder.memberSchool.text = member.school
        holder.memberYear.text = years[member.year]
        holder.memberDepartment.text = member.department
        holder.memberResidence.text = member.residence
        holder.memberCard.setOnClickListener { onClick.onMemberClicked(member) }
    }

    override fun getItemCount(): Int {
        return membersList.size
    }

    fun filterList(search: String){
        membersList.clear()
        for (member in fullList){
            if (member.name.lowercase(Locale.ROOT).contains(search.lowercase(Locale.ROOT)) ||
                member.email.lowercase(Locale.ROOT).contains(search.lowercase(Locale.ROOT))){
                membersList.add(member)
            }
        }
        notifyDataSetChanged()
    }

    inner class AdminHomeRecyclerViewModel(itemView: View) : RecyclerView.ViewHolder(itemView){
        val memberContainer = itemView.findViewById<ConstraintLayout>(R.id.memberContainer)
        val memberCard = itemView.findViewById<CardView>(R.id.memberCard)
        val memberID = itemView.findViewById<TextView>(R.id.memberID)
        val memberName = itemView.findViewById<TextView>(R.id.memberName)
        val memberNumber = itemView.findViewById<TextView>(R.id.memberNumber)
        val memberEmail = itemView.findViewById<TextView>(R.id.memberEmail)
        val memberRegNo = itemView.findViewById<TextView>(R.id.memberRegNo)
        val memberSchool = itemView.findViewById<TextView>(R.id.memberSchool)
        val memberYear = itemView.findViewById<TextView>(R.id.memberYear)
        val memberDepartment = itemView.findViewById<TextView>(R.id.memberDepartment)
        val memberResidence = itemView.findViewById<TextView>(R.id.memberResidence)
    }
}