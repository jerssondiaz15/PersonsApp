package com.example.personsapp.domain.repository

import com.example.personsapp.domain.model.Person

interface IPersonRepository {

    suspend fun getListPerson(): List<Person>
    suspend fun deleteAllPerson()
    suspend fun insertPerson(person: Person)

}