package com.example.personsapp.data.person.remote.network

import com.example.personsapp.data.person.remote.model.ListPersonResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PersonService @Inject constructor(
    private val api: PersonApiClient
) {

    suspend fun getListPerson(): ListPersonResponse?{
        return withContext(Dispatchers.IO){
            val response = api.getListPerson(
                results = RESULTS
            )
            response.body()
        }
    }

    companion object {
        private const val RESULTS = 50
    }
}