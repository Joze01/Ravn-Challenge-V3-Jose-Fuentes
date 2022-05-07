package com.ravn.starwarswiki.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.ravn.starwarswiki.data.model.PersonDetailsModel
import com.ravn.starwarswiki.domain.GetPeoplePaging
import com.ravn.starwarswiki.domain.GetPersonDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val getPersonDetails: GetPersonDetails, private val getPeoplePaging: GetPeoplePaging
) : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val personDetails = MutableLiveData<PersonDetailsModel>()
    val pager = Pager(PagingConfig(pageSize = 5)){
        getPeoplePaging
    }.flow.cachedIn(viewModelScope)



    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
//            val peoplePageModel = getPeople(null)!!
//            val personModel = getPeoplePaging()
//            peopleList.postValue(peoplePageModel)
//            pageInfo.postValue(peoplePageModel.pageInfoModel)
//            peoplePageModel.
            isLoading.postValue(false)
        }
    }

    fun loadPersonDetails(id:String) {
        viewModelScope.launch {
            personDetails.postValue(getPersonDetails(id)!!)
        }
    }
}