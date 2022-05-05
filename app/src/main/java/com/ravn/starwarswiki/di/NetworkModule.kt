package com.ravn.starwarswiki.di

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providerApollo(): ApolloClient {
        return ApolloClient.builder()
            .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index").build()
    }
}