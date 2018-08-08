package com.example.caseynelson.leaguearchitecture.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (val app: Application) {

    @Provides
    @Singleton
    fun providesApp(): Application = app

}