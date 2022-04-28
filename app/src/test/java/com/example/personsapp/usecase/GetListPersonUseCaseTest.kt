package com.example.personsapp.usecase

import com.example.personsapp.data.person.remote.PersonRemoteRepository
import com.example.personsapp.domain.model.Person
import com.example.personsapp.domain.repository.IPersonRepository
import com.example.personsapp.domain.test.listPerson
import com.example.personsapp.domain.usecase.GetListPersonUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetListPersonUseCaseTest {

    @RelaxedMockK
    private lateinit var iPersonRepository: IPersonRepository

    @RelaxedMockK
    private lateinit var repository: PersonRemoteRepository

    lateinit var getListPersonsUseCase: GetListPersonUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getListPersonsUseCase = GetListPersonUseCase(iPersonRepository, repository)
    }

    @Test
    fun `when the api return the Person data from api`() = runBlocking {
        //Given
        val data: List<Person> = listPerson
        coEvery { repository.getListPerson() } returns data

        //When
        val response = getListPersonsUseCase.invoke()

        //Then
        coVerify(exactly = 1) { repository.getListPerson() }
        assert(response == data)
    }

    @Test
    fun `when the api return the Person data from database`() = runBlocking {
        //Given
        val data: List<Person> = listPerson
        coEvery { iPersonRepository.getListPerson() } returns data

        //When
        val response = getListPersonsUseCase.invoke()

        //Then
        coVerify(exactly = 1) { iPersonRepository.getListPerson() }
        assert(response == data)
    }
}