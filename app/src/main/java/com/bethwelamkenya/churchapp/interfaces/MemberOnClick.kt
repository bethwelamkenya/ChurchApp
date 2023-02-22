package com.bethwelamkenya.churchapp.interfaces

import androidx.cardview.widget.CardView
import com.bethwelamkenya.churchapp.model.Member

interface MemberOnClick {
    fun onMemberClicked(member: Member)
    fun onMemberLonClicked(member: Member, cardView: CardView)
}