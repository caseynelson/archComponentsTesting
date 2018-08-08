package com.example.caseynelson.leaguearchitecture.repository

import Constants
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.caseynelson.leaguearchitecture.api.RiotService
import com.example.caseynelson.leaguearchitecture.db.ChampionDao
import com.example.caseynelson.leaguearchitecture.model.RiotResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton
import android.os.AsyncTask
import com.example.caseynelson.leaguearchitecture.model.ChampionDto


@Singleton
class ChampionRepository @Inject constructor(
        private val championDao: ChampionDao,
        private val riotService: RiotService) {

    fun getChampions(): LiveData<List<ChampionDto>> {

        riotService.getChampions(Constants.RIOT_API_KEY).enqueue(object : Callback<RiotResponse> {
            override fun onResponse(call: Call<RiotResponse>?, response: Response<RiotResponse>?) {
                InsertAsyncTask(championDao).execute(response?.body()?.data)

            }

            override fun onFailure(call: Call<RiotResponse>?, t: Throwable?) {}

        })

        return championDao.getAllChampions()
    }

    private class InsertAsyncTask internal constructor(private val championDao: ChampionDao) : AsyncTask<Map<String, ChampionDto>, Void, Void>() {

        override fun doInBackground(vararg params: Map<String, ChampionDto>?): Void? {
            params[0]?.forEach { championDao.insert(it.value) }
            return null
        }
    }
}