package com.example.caseynelson.leaguearchitecture.di.components

import android.app.Application
import com.example.caseynelson.leaguearchitecture.di.modules.AppModule
import com.example.caseynelson.leaguearchitecture.di.modules.NetworkModule
import com.example.caseynelson.leaguearchitecture.di.modules.RoomModule
import com.example.caseynelson.leaguearchitecture.di.modules.ViewModelModule
import com.example.caseynelson.leaguearchitecture.ui.ChampionViewModel
import com.example.caseynelson.leaguearchitecture.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ViewModelModule::class, RoomModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(application: Application)
}