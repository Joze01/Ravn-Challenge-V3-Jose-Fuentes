package com.ravn.starwarswiki.domain

import com.ravn.starwarswiki.GetAllPeopleQuery
import com.ravn.starwarswiki.data.StarwarsRepository
import com.ravn.starwarswiki.data.respository.PersonRepository
import javax.inject.Inject

class GetPeople @Inject constructor(private val repository: PersonRepository) {
//    suspend operator fun invoke() = repository.queryPeopleList()

    suspend operator fun invoke() : String? {
        val query = repository.queryPeopleList()
        val luke: GetAllPeopleQuery.Person? = query.data?.allPeople?.people?.get(0)

        return luke?.personFragment?.name
    }
}