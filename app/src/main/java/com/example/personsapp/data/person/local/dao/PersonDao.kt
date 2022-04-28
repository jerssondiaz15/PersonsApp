package com.example.personsapp.data.person.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.personsapp.data.person.local.model.DbPerson

@Dao
interface PersonDao {

    @Query("SELECT * FROM person_table")
    suspend fun getListDbPerson(): List<DbPerson>

    @Query("DELETE FROM person_table")
    suspend fun deleteAllPersons()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPerson(dbMovie: DbPerson)

}