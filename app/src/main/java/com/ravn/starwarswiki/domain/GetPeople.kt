package com.ravn.starwarswiki.domain

import com.ravn.starwarswiki.data.StarwarsRepository
import javax.inject.Inject

class GetPeople @Inject constructor(private val repository: StarwarsRepository) {
    suspend operator fun invoke() = repository.getAllPeople()
}