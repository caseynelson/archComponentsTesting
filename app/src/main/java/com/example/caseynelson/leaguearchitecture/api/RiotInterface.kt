package com.example.caseynelson.leaguearchitecture.api

import android.arch.lifecycle.LiveData
import com.example.caseynelson.leaguearchitecture.model.ChampionDto
import com.example.caseynelson.leaguearchitecture.model.RiotResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

/**
* REST API ACCESS POINTS
*/
interface RiotService {
//    @Headers("Origin: https://developer.riotgames.com",
//            "Accept-Charset: application/x-www-form-urlencoded; charset=UTF-8",
//            "X-Riot-Token: RGAPI-c885a4e0-2cd7-46e6-ba2d-aa06090d24f6",
//            "Accept-Language: en-US,en;q=0.9",
//            "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.75 Safari/537.36")
    @GET("/lol/static-data/v3/champions")
    fun getChampions(@Query("api_key") apiKey: String): Call<RiotResponse>
}
