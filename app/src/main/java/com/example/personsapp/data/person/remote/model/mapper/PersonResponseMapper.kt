package com.example.personsapp.data.person.remote.model.mapper

import com.example.personsapp.data.person.remote.model.PersonResponse
import com.example.personsapp.domain.model.Name
import com.example.personsapp.domain.model.Person

fun List<PersonResponse>.toListPerson(): List<Person> = this.map { it.toPerson() }
fun PersonResponse.toPerson(): Person = with(this){
    Person(
        name = Name(
            title = name.title,
            first = name.first,
            last = name.last
        ),
        email = email,
        photo = photo.medium,
        gender = gender,
        age = dob.age,
        city = location.city
    )
}