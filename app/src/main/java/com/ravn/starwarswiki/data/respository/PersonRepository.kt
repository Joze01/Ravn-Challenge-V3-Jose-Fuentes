package com.ravn.starwarswiki.data.respository

import com.apollographql.apollo3.api.ApolloResponse
import com.ravn.starwarswiki.GetAllPeopleQuery
import com.ravn.starwarswiki.GetPersonDetailsQuery

interface PersonRepository {
    suspend fun queryPeopleList(cursor: String?): ApolloResponse<GetAllPeopleQuery.Data>

    suspend fun queryPersonDetails(id: String): ApolloResponse<GetPersonDetailsQuery.Data>
}