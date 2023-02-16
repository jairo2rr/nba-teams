package com.example.pronosticobasket.domain

import com.example.pronosticobasket.data.BasketRepository
import com.example.pronosticobasket.data.model.ResponseTeam
import javax.inject.Inject

class GetAllTeams @Inject constructor(private val repository: BasketRepository) {
    suspend operator fun invoke():ResponseTeam?{
        return repository.getAllTeams()
    }
}