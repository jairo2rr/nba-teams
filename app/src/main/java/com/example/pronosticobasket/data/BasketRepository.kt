package com.example.pronosticobasket.data

import com.example.pronosticobasket.data.model.ResponseTeam
import com.example.pronosticobasket.data.model.Team
import com.example.pronosticobasket.data.network.BasketService
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api:BasketService
){
    suspend fun getAllTeams():ResponseTeam?{
        return api.getTeams()
    }

    suspend fun getInfoTeam(id:Int): Team?{
        return api.getInfoTeam(id)
    }
}