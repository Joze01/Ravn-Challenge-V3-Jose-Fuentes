package com.ravn.starwarswiki.data

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.ravn.starwarswiki.GetAllPeopleQuery
import javax.inject.Inject

class StarwarsRepository {

    private val serveUrl = "https://swapi-graphql.netlify.app/.netlify/functions/index"
    //TODO reuse as singleton
    private val apolloClient = ApolloClient.Builder().serverUrl(serveUrl).build()

    suspend fun getAllPeople() {
       var response: ApolloResponse<GetAllPeopleQuery.Data> = apolloClient.query(GetAllPeopleQuery()).execute()

        Log.d("jos", " success ${response.data}")
    }
}

//class StarwarsRepository @Inject constructor(
//
//){
//
//}