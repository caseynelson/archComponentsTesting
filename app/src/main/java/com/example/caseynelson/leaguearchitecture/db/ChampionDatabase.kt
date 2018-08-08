package com.example.caseynelson.leaguearchitecture.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.caseynelson.leaguearchitecture.model.ChampionDto

/**
* Database to hold champion information locally
*/

@Database(entities = [ChampionDto::class], version = 1)
abstract class ChampionDatabase : RoomDatabase() {

    abstract fun ChampionDao(): ChampionDao
}