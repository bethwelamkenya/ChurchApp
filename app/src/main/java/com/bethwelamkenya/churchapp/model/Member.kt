package com.bethwelamkenya.churchapp.model

data class Member(
    var id: Long,
    var name: String,
    var email: String,
    var regNo: String,
    var number: Long,
    var school: String,
    var year: Int,
    var department: String,
    var residence: String
){
    constructor(
        name: String,
        email: String,
        regNo: String,
        number: Long,
        school: String,
        year: Int,
        department: String,
        residence: String
    ) : this(0, name, email, regNo, number, school, year, department, residence)
}
