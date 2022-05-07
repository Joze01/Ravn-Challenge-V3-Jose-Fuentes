package com.ravn.starwarswiki.domain

import android.util.Log
import com.ravn.starwarswiki.data.model.PersonDetailsModel
import com.ravn.starwarswiki.data.respository.PersonRepository
import javax.inject.Inject

class GetPersonDetails @Inject constructor(private val repository: PersonRepository) {
    suspend operator fun invoke(id: String): PersonDetailsModel {
        val query = repository.queryPersonDetails(id)
        val response = query.data?.person
        return try {
            PersonDetailsModel(
                response?.name ?: UNDEFINED,
                response?.eyeColor ?: UNDEFINED,
                response?.hairColor ?: UNDEFINED,
                response?.skinColor ?: UNDEFINED,
                response?.birthYear ?: UNDEFINED,
                response?.vehicleConnection?.edges?.map {
                    it?.node?.name?.toString() ?: UNDEFINED
                }
            )
        } catch (e: Exception) {
            Log.d("GetPersonDetail", e.message.toString())
            PersonDetailsModel(UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, null)
        }
    }

    companion object {
        const val UNDEFINED: String = "undefined"
    }
}