package com.example.personsapp.data.person.local

import com.example.personsapp.data.person.local.datasource.PersonDatabaseDataSource
import com.example.personsapp.data.person.local.model.mapper.toDbPerson
import com.example.personsapp.data.person.local.model.mapper.toListPerson
import com.example.personsapp.domain.model.Person
import com.example.personsapp.domain.repository.IPersonRepository
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val personDatabaseDataSource: PersonDatabaseDataSource
): IPersonRepository {
    override suspend fun getListPerson(): List<Person> {
        return personDatabaseDataSource.getListDbPerson().toListPerson()
    }

    override suspend fun deleteAllPerson() {
        personDatabaseDataSource.deleteAllPerson()
    }

    override suspend fun insertPerson(person: Person) {
        personDatabaseDataSource.insertPerson(person.toDbPerson())
    }
}