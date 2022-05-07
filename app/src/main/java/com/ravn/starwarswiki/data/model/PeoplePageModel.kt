package com.ravn.starwarswiki.data.model

data class PeoplePageModel(
    val pageInfoModel: PageInfoModel,
    val peopleListModel: List<PersonModel>
)