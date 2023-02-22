package com.bethwelamkenya.churchapp.model

data class Member(
    val id: Long,
    val name: String,
    val email: String,
    val regNo: String,
    val number: Long,
    val school: String,
    val year: Int,
    val department: String,
    val residence: String
): java.io.Serializable{
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
