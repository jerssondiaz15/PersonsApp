package com.example.personsapp.data.person.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.personsapp.data.person.local.dao.PersonDao
import com.example.personsapp.data.person.local.model.DbPerson

@Database(
    entities = [
        DbPerson::class
    ],
    version = 1
)

abstract class PersonDataBase: RoomDatabase() {
    abstract fun personDao(): PersonDao
}