package com.example.pronosticobasket.data.model

import com.google.gson.annotations.SerializedName

data class ResponseTeam(
    @SerializedName("data")
    val teams: List<Team>,
    val meta: Meta
)