package com.ravn.starwarswiki.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ravn.starwarswiki.data.model.PersonModel
import com.ravn.starwarswiki.data.respository.PersonRepository
import javax.inject.Inject

class GetPeoplePaging @Inject constructor(private val personRepository: PersonRepository) :
    PagingSource<String, PersonModel>() {


    override fun getRefreshKey(state: PagingState<String, PersonModel>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, PersonModel> {
        return try {
            val cursor = params.key
            var response = personRepository.queryPeopleList(cursor)
            val pageInfo = response.data?.allPeople?.pageInfo
            var prevCursor: String? = null
            var nextCursor: String? = null
            if (pageInfo?.hasNextPage == true) {
                nextCursor = pageInfo?.endCursor
            }
            if (pageInfo?.hasPreviousPage == true) {
                prevCursor = pageInfo?.startCursor
            }
            val personModel = response.data?.allPeople?.edges?.map {
                PersonModel(
                    it?.node?.id!!,
                    it?.node?.name,
                    it?.node?.species?.name ?: "Human",
                    it?.node?.homeworld?.name
                )
            }!!

            LoadResult.Page(
                data = personModel,
                prevKey = prevCursor,
                nextKey = nextCursor
            )


        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}