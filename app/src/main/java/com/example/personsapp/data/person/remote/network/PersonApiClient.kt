package com.example.personsapp.data.person.remote.network

import com.example.personsapp.data.person.remote.model.ListPersonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PersonApiClient {

    @GET("api/")
    suspend fun getListPerson(
        @Query("results") results: Int
    ): Response<ListPersonResponse>

}