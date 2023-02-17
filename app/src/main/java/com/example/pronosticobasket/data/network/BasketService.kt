package com.example.pronosticobasket.data.network

import com.example.pronosticobasket.data.model.ResponseGame
import com.example.pronosticobasket.data.model.ResponseTeam
import com.example.pronosticobasket.data.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BasketService @Inject constructor(private val api:BasketApiClient) {
    suspend fun getTeams():ResponseTeam? {
        return withContext(Dispatchers.IO){
            val response = api.getAllTeams()
            response.body()
        }
    }

    suspend fun getInfoTeam(id:Int):Team?{
        return withContext(Dispatchers.IO){
            val response = api.getInfoTeam(id)
            response.body()
        }
    }

    suspend fun getGameTeam(team_id:Int):ResponseGame?{
        return withContext(Dispatchers.IO){
            val response = api.getGamesTeam(team_id)
            response.body()
        }
    }
}