package com.bethwelamkenya.churchapp.model

data class Admin(
    var id: Long,
    var name: String,
    var email: String,
    var number: Long,
    var userName: String,
    var password: String,
    var security: String,
    var answer: String
){
    constructor(
        name: String,
        email: String,
        number: Long,
        userName: String,
        password: String,
        security: String,
        answer: String
    ) : this(0, name, email, number, userName, password, security, answer)
}

