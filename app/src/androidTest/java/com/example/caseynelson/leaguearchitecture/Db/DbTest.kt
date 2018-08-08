package com.example.caseynelson.leaguearchitecture.Db

import android.arch.core.executor.testing.CountingTaskExecutorRule
import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import com.example.caseynelson.leaguearchitecture.db.ChampionDatabase
import org.junit.After
import org.junit.Before
import org.junit.Rule

abstract class DbTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var _db : ChampionDatabase
    val db: ChampionDatabase
        get() = _db

    @Before
    fun initDb() {
        _db = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                ChampionDatabase::class.java)
                .allowMainThreadQueries()
                .build()
    }

    @After
    fun closeDb() {
        _db.close()
    }
}