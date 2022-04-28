package com.example.personsapp.data.person.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "person_table"
)
data class DbPerson(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int? = 0,
    @ColumnInfo(name = "name") val tittle: String? = "",
    @ColumnInfo(name = "firstName") val firstName: String? = "",
    @ColumnInfo(name = "lastName") val lastName: String? = "",
    @ColumnInfo(name = "email") val email: String? = "",
    @ColumnInfo(name = "photo") val photo: String? = "",
    @ColumnInfo(name = "gender") val gender: String? = "",
    @ColumnInfo(name = "age") val age: Int? = 0,
    @ColumnInfo(name = "city") val city: String? = ""
)
