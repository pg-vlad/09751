package com.nikak.linadom.testsubject2

data class User(val id: Long, val login: String, val password: String) {
    constructor(nameInput: String, passwordInput: String) : this(0,nameInput,passwordInput)
}