package com.ravn.starwarswiki.data

import com.apollographql.apollo3.ApolloClient

class StarwarsRepository {

    private val serveUrl = "https://swapi-graphql.netlify.app/.netlify/functions/index"
    //TODO reuse as singleton
    private val apolloClient = ApolloClient.Builder().serverUrl(serveUrl).build()
}