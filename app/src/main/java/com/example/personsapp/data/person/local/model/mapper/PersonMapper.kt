package com.example.personsapp.data.person.local.model.mapper

import com.example.personsapp.data.person.local.model.DbPerson
import com.example.personsapp.domain.model.Name
import com.example.personsapp.domain.model.Person

fun List<DbPerson>.toListPerson(): List<Person> = this.map { it.toPerson() }
fun DbPerson.toPerson(): Person = with(this){
    Person(
        id = id,
        name = Name(
            title = tittle,
            first = firstName,
            last = lastName
        ),
        email = email,
        photo = photo,
        gender = gender,
        age = age,
        city = city
    )
}

fun List<Person>.toDbPerson(): List<DbPerson> = this.map { it.toDbPerson() }
fun Person.toDbPerson(): DbPerson = with(this){
    DbPerson(
        id = id,
        tittle = name.title,
        firstName = name.first,
        lastName = name.last,
        email = email,
        photo = photo,
        gender = gender,
        age = age,
        city = city
    )
}