package com.ravn.starwarswiki.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PeopleViewModel @Inject constructor() : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            //TODO get the first data
            isLoading.postValue( false)
        }
    }
}