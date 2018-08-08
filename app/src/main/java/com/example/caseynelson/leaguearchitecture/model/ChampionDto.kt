package com.example.caseynelson.leaguearchitecture.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "champion")
data class ChampionDto(
        @PrimaryKey
        @SerializedName("id") val id: Int,
        @SerializedName("title") val title: String,
        @SerializedName("name") val name: String)
