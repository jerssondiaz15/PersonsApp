package com.example.personsapp.domain.model

data class Person(
    val id: Int? = 0,
    val name: Name,
    val email: String? = "",
    val photo: String? = "",
    val gender: String? = "",
    val age: Int? = 0,
    val city: String? = ""
)

data class Name(
    val title: String? = "",
    val first: String? = "",
    val last: String? = ""
)