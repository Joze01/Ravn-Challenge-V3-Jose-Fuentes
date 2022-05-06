package com.ravn.starwarswiki.data.respository

import com.apollographql.apollo3.api.ApolloResponse
import com.ravn.starwarswiki.GetAllPeopleQuery

interface PersonRepository {
    suspend fun queryPeopleList(): ApolloResponse<GetAllPeopleQuery.Data>
}