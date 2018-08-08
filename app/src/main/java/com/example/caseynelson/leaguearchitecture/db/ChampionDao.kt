package com.example.caseynelson.leaguearchitecture.db

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.caseynelson.leaguearchitecture.model.ChampionDto


/**
 * Interface for database access for Champion related queries
*/

@Dao
interface ChampionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(champion : ChampionDto)

    @Query("SELECT * FROM champion WHERE name = :name")
    fun getChampion(name: String) : LiveData<ChampionDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(champions : List<ChampionDto>)

    @Query("SELECT * FROM champion")
    fun getAllChampions(): LiveData<List<ChampionDto>>

}