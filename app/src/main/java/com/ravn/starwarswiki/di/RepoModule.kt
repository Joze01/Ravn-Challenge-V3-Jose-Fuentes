package com.ravn.starwarswiki.di

import com.apollographql.apollo.ApolloClient
import com.ravn.starwarswiki.network.StarWarsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Singleton
    @Provides
    fun providesWebService() = StarWarsAPI()
}