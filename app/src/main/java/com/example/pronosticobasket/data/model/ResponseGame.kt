package com.example.pronosticobasket.data.model

import com.google.gson.annotations.SerializedName

data class ResponseGame (
    @SerializedName("data")
    val games: List<Game>,
    val meta: Meta
)