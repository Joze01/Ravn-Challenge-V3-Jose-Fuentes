package com.ravn.starwarswiki.di

import com.ravn.starwarswiki.data.respository.PersonRepository
import com.ravn.starwarswiki.data.respository.PersonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule{
    @Binds
    @ViewModelScoped
    abstract fun bindRepository(repo: PersonRepositoryImpl) : PersonRepository
}