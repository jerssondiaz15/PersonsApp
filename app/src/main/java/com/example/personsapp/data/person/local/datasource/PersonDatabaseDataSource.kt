package com.example.personsapp.data.person.local.datasource

import com.example.personsapp.data.person.local.PersonDataBase
import com.example.personsapp.data.person.local.model.DbPerson

class PersonDatabaseDataSource(
    private val personDataBase: PersonDataBase
) {

    suspend fun getListDbPerson(): List<DbPerson> {
        return personDataBase.personDao().getListDbPerson()
    }

    suspend fun deleteAllPerson(){
        personDataBase.personDao().deleteAllPersons()
    }

    suspend fun insertPerson(dbPerson: DbPerson){
        personDataBase.personDao().insertPerson(dbPerson)
    }

}