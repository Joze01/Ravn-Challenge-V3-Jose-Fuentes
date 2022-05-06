package com.ravn.starwarswiki.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravn.starwarswiki.data.respository.PersonRepository
import com.ravn.starwarswiki.domain.GetPeople
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
//    private val repository: PersonRepository
    private val getPeople: GetPeople
) : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val luke = MutableLiveData<String>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
//            var test =  repository.queryPeopleList()
            var test = getPeople()
            test?.let {
                luke.postValue(test!!)
                Log.d("josee", it) }
            isLoading.postValue( false)
        }
    }
}