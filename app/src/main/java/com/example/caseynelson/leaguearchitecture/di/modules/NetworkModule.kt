package com.example.caseynelson.leaguearchitecture.di.modules

import android.arch.lifecycle.LiveData
import com.example.caseynelson.leaguearchitecture.api.RiotService
import com.github.leonardoxh.livedatacalladapter.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): RiotService {
        return Retrofit.Builder()
                .baseUrl(Constants.RIOT_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .build()
                .create(RiotService::class.java)
    }
}