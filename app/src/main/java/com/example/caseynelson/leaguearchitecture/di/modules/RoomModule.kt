package com.example.caseynelson.leaguearchitecture.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import com.example.caseynelson.leaguearchitecture.api.RiotService
import com.example.caseynelson.leaguearchitecture.db.ChampionDao
import com.example.caseynelson.leaguearchitecture.db.ChampionDatabase
import com.example.caseynelson.leaguearchitecture.repository.ChampionRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(val app: Application) {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : ChampionDatabase {
        return Room
                .databaseBuilder(app, ChampionDatabase::class.java, "champion database")
                .build()
    }

    @Provides
    @Singleton
    fun provideChampionRepository(championDao: ChampionDao, riotService: RiotService) : ChampionRepository {
        return ChampionRepository(championDao, riotService)
    }

    @Provides
    @Singleton
    fun provideChampionDao(database: ChampionDatabase) : ChampionDao {
        return database.ChampionDao()
    }
}