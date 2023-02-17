package com.bethwelamkenya.churchapp.model

data class Attendance(
    var attendanceID: Long,
    var id: Long,
    var name: String,
    var date: String,
    var status: Int
){
    constructor(
        id: Long,
        name: String,
        date: String,
        status: Int
    ) : this (0, id, name, date, status)
}
