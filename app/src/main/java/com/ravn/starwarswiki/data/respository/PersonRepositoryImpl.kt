package com.ravn.starwarswiki.data.respository


import com.apollographql.apollo3.api.ApolloResponse
import com.ravn.starwarswiki.GetAllPeopleQuery
import com.ravn.starwarswiki.network.StarWarsAPI
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor(
    private val webService: StarWarsAPI
) : PersonRepository {
    override suspend fun queryPeopleList(): ApolloResponse<GetAllPeopleQuery.Data> {
        return webService.getApolloCLient().query(GetAllPeopleQuery()).execute()
    }
}