package com.ravn.starwarswiki.data.respository

import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Optional
import com.ravn.starwarswiki.GetAllPeopleQuery
import com.ravn.starwarswiki.GetPersonDetailsQuery
import com.ravn.starwarswiki.network.StarWarsAPI
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(
    private val webService: StarWarsAPI
) : PersonRepository {
    override suspend fun queryPeopleList(cursor: String?): ApolloResponse<GetAllPeopleQuery.Data> {
        return webService.getApolloCLient()
            .query(GetAllPeopleQuery(Optional.presentIfNotNull(cursor))).execute()
    }

    override suspend fun queryPersonDetails(id: String): ApolloResponse<GetPersonDetailsQuery.Data> {
        return webService.getApolloCLient()
            .query(GetPersonDetailsQuery(Optional.presentIfNotNull(id))).execute()
    }
}