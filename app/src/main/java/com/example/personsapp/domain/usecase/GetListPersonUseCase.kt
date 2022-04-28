package com.example.personsapp.domain.usecase

import com.example.personsapp.data.person.remote.PersonRemoteRepository
import com.example.personsapp.domain.model.Person
import com.example.personsapp.domain.repository.IPersonRepository
import javax.inject.Inject

class GetListPersonUseCase @Inject constructor(
    private val iPersonRepository: IPersonRepository,
    private val repository: PersonRemoteRepository
) {

    suspend operator fun invoke(): List<Person>{
        val person = repository.getListPerson()
        return if (person!!.isNotEmpty()){
            iPersonRepository.deleteAllPerson()
            person.map{ item ->
                iPersonRepository.insertPerson(item)
            }
            person
        } else{
            iPersonRepository.getListPerson()
        }
    }

}