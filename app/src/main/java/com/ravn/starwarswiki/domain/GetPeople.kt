package com.ravn.starwarswiki.domain

import android.util.Log
import com.ravn.starwarswiki.data.model.PageInfoModel
import com.ravn.starwarswiki.data.model.PeoplePageModel
import com.ravn.starwarswiki.data.model.PersonModel
import com.ravn.starwarswiki.data.respository.PersonRepository
import javax.inject.Inject

class GetPeople @Inject constructor(private val repository: PersonRepository) {
    suspend operator fun invoke(cursor: String?): PeoplePageModel {
        val query = repository.queryPeopleList(cursor)
        val pageInfo = query.data?.allPeople?.pageInfo
        Log.d("GetPeople", pageInfo?.hasNextPage.toString())
        Log.d("GetPeople", pageInfo?.endCursor.toString())

        return PeoplePageModel(
            PageInfoModel(
                pageInfo?.hasNextPage ?: false,
                pageInfo?.hasPreviousPage ?: false,
                pageInfo?.startCursor!!,
                pageInfo.endCursor!!,
            ),
            query.data?.allPeople?.edges?.map {
                PersonModel(
                    it?.node?.id!!,
                    it.node.name,
                    it.node.species?.name ?: "Human",
                    it.node.homeworld?.name
                )
            }!!
        )
    }
}