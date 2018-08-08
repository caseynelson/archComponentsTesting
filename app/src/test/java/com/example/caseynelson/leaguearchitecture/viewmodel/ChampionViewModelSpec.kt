package com.example.caseynelson.leaguearchitecture.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import com.example.caseynelson.leaguearchitecture.model.ChampionDto
import com.example.caseynelson.leaguearchitecture.repository.ChampionRepository
import com.example.caseynelson.leaguearchitecture.ui.ChampionViewModel
import com.greghaskins.spectrum.Spectrum
import com.greghaskins.spectrum.Spectrum.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.mock
import org.mockito.Mock
import com.nhaarman.mockito_kotlin.*


import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@RunWith(Spectrum::class)
class ChampionViewModelSpec {

    private lateinit var viewModel: ChampionViewModel

    @Mock
    private lateinit var mockRepository: ChampionRepository

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    init {
        describe("ChampionViewModel") {
            beforeEach {
                MockitoAnnotations.initMocks(this)
                viewModel = ChampionViewModel(mockRepository)
            }

            describe("#init") {
                describe("when list is null") {
                    val data: LiveData<List<ChampionDto>>? = null

                    beforeEach {
                        given(mockRepository.getChampions()).willReturn(data)
                        viewModel.init()
                    }

                    it("should make it call to get champions ") {
                        verify(mockRepository).getChampions()
                    }
                }
            }
        }
    }
}