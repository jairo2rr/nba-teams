package com.example.pronosticobasket.data.model

import com.google.gson.annotations.SerializedName

data class ResponsePlayer(
    @SerializedName("data")
    val players: List<Player>,
    val meta: Meta
)