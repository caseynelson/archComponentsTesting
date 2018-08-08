package com.example.caseynelson.leaguearchitecture

import android.app.Application
import com.example.caseynelson.leaguearchitecture.di.components.AppComponent
import com.example.caseynelson.leaguearchitecture.di.components.DaggerAppComponent
import com.example.caseynelson.leaguearchitecture.di.modules.AppModule
import com.example.caseynelson.leaguearchitecture.di.modules.NetworkModule
import com.example.caseynelson.leaguearchitecture.di.modules.RoomModule
import com.example.caseynelson.leaguearchitecture.di.modules.ViewModelModule

class ChampionApplication : Application() {

    val appComponent : AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .roomModule(RoomModule(this))
                .build()
    }

    //use this for possible better way to test
//    companion object {
//        lateinit var graph: AppComponent
//    }

    override fun onCreate() {
        super.onCreate()
       appComponent.inject(this)

        //appComponenet = DaggerAppComponenet.write out the full sequence above
    }

    fun appComponent() : AppComponent = appComponent

}