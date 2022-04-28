package com.example.personsapp.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personsapp.domain.model.Person
import com.example.personsapp.domain.usecase.GetListPersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val getListPersonUseCase: GetListPersonUseCase
): ViewModel() {

    private val _listPerson = MutableLiveData<List<Person>>()
    val listPerson: LiveData<List<Person>> get() = _listPerson

    private val _person = MutableLiveData<Person>()
    val person: LiveData<Person> get() = _person

    fun setPerson(person: Person){
        _person.postValue(person)
    }

    init {
        getList()
    }

    private fun getList() {
        viewModelScope.launch {
            val result = getListPersonUseCase.invoke()
            _listPerson.postValue(result)
            Log.i("result: ", result.toString())
        }
    }

}