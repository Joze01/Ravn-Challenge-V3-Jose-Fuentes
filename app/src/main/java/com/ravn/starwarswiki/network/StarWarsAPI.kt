package com.ravn.starwarswiki.network

import android.os.Looper
import com.apollographql.apollo3.ApolloClient

class StarWarsAPI {
    fun getApolloCLient():ApolloClient{
        check(Looper.myLooper() == Looper.getMainLooper()){
            "Only the main thread can get the apolloClient instance"
        }
        return  ApolloClient.Builder()
            .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index").build()
    }
}