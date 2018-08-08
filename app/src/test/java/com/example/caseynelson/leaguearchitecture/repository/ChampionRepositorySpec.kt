package com.example.caseynelson.leaguearchitecture.repository

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.caseynelson.leaguearchitecture.api.RiotService
import com.example.caseynelson.leaguearchitecture.db.ChampionDao
import com.example.caseynelson.leaguearchitecture.model.RiotResponse
import com.greghaskins.spectrum.Spectrum
import com.greghaskins.spectrum.Spectrum.*
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Call

@RunWith(Spectrum::class)
class ChampionRepositorySpec{

    private lateinit var championRepository: ChampionRepository

    @Mock
    private lateinit var mockChampionDao: ChampionDao

    @Mock
    private lateinit var mockService: RiotService

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    init {
        describe("ChampionRepository") {
            beforeEach {
                MockitoAnnotations.initMocks(this)
                championRepository = ChampionRepository(mockChampionDao, mockService)
            }

            describe("#getChampions") {
                beforeEach {
                    //given(mockService.getChampions(Constants.RIOT_API_KEY)).willReturn()
                }
                it("should retrive champion list") {
                    //championRepository.getChampions()
                    verify(mockChampionDao).getAllChampions()
                }
            }


        }
    }
}