package com.example.caseynelson.leaguearchitecture.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.caseynelson.leaguearchitecture.model.ChampionDto
import com.example.caseynelson.leaguearchitecture.model.RiotResponse
import com.example.caseynelson.leaguearchitecture.repository.ChampionRepository
import javax.inject.Inject

class ChampionViewModel @Inject constructor(private val repository: ChampionRepository) : ViewModel() {
    private var championList: LiveData<List<ChampionDto>>? = null

    fun init() {
        if (championList != null) {
            return
        }
        championList = repository.getChampions()
    }

    fun getChampionList() : LiveData<List<ChampionDto>>? {
        return this.championList
    }
}