package com.example.personsapp.data.person.remote

import com.example.personsapp.data.person.remote.model.mapper.toListPerson
import com.example.personsapp.data.person.remote.network.PersonService
import com.example.personsapp.domain.model.Person
import javax.inject.Inject

class PersonRemoteRepository @Inject constructor(
    private val api: PersonService
) {

    suspend fun getListPerson(): List<Person>? {
        val response = api.getListPerson()
        return response?.listPerson?.toListPerson()
    }

}