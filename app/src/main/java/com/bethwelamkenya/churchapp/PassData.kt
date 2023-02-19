package com.bethwelamkenya.churchapp

import com.bethwelamkenya.churchapp.model.Admin
import com.bethwelamkenya.churchapp.model.Member
import java.util.*

class PassData {
    private fun trying(userName: String, thePassword: String): ArrayList<String> {
        val arrays = arrayOf(userName, thePassword)
        val array2 = arrayOf("Hi Here", "Hi There")
        val arrayList = ArrayList<String>()
        arrayList.add("The Here")
        arrayList.addAll(listOf(*arrays))
        arrayList.addAll(listOf(*array2))
        return arrayList
    }

    companion object {
        var admin: Admin? = null
        var resetAdmin: Admin? = null
        var message: String? = null
        var adminName: String? = null
        var firstTime = false
        var passedMember: Member? = null
    }
}