package com.example.pronosticobasket.data.network

import com.example.pronosticobasket.data.model.ResponseGame
import com.example.pronosticobasket.data.model.ResponseTeam
import com.example.pronosticobasket.data.model.Team
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryName

interface BasketApiClient {
    @GET("teams")
    suspend fun getAllTeams():Response<ResponseTeam>

    @GET("teams/{ID}")
    suspend fun getInfoTeam(@Path("ID")id:Int):Response<Team>

    @GET("games")
    suspend fun getGamesTeam(@Query("team_ids") team_id:Int):Response<ResponseGame>
}