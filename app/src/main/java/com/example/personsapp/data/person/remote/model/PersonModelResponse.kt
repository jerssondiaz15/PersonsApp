package com.example.personsapp.data.person.remote.model

import com.google.gson.annotations.SerializedName

data class ListPersonResponse(
    @SerializedName("results") val listPerson: List<PersonResponse> = emptyList(),
)

data class PersonResponse(
    @SerializedName("name") val name: Name,
    @SerializedName("email") val email: String = "",
    @SerializedName("picture") val photo: Photo,
    @SerializedName("gender") val gender: String = "",
    @SerializedName("dob") val dob: Dob,
    @SerializedName("location") val location: Location,
)

data class Name(
    @SerializedName("title") val title: String = "",
    @SerializedName("first") val first: String = "",
    @SerializedName("last") val last: String = "",
)

data class Photo(
    @SerializedName("medium") val medium: String = "",
)

data class Dob(
    @SerializedName("age") val age: Int = 0,
)

data class Location(
    @SerializedName("city") val city: String = "",
)