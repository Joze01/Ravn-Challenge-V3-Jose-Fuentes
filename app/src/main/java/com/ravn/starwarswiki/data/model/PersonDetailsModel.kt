package com.ravn.starwarswiki.data.model

data class PersonDetailsModel(
    val eyeColor: String,
    val hairColor: String,
    val skinColor: String,
    val birthYear: String,
    val vehicles: List<String>
)