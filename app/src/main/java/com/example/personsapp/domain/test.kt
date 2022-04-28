package com.example.personsapp.domain

import com.example.personsapp.domain.model.Name
import com.example.personsapp.domain.model.Person

object test {
    val listPerson = listOf(
        Person(
            id = 1,
            name = Name(
                title = "MR",
                first = "Jersson",
                last = "Diaz"
            ),
            email = "jerson.diaz.15@gmail.com",
            photo = "https://randomuser.me/api/portraits/med/men/34.jpg",
            gender = "male",
            age = 29,
            city = "Lima"
        )
    )
}