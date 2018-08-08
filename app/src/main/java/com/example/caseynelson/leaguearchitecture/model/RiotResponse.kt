package com.example.caseynelson.leaguearchitecture.model

import com.google.gson.annotations.SerializedName

class RiotResponse (
    @SerializedName("version") val version: String,
    @SerializedName("type") val type: String,
    @SerializedName("data") val data: Map<String, ChampionDto>)




