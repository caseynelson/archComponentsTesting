package com.example.caseynelson.leaguearchitecture.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.view.View
import com.example.caseynelson.leaguearchitecture.ViewModelFactory
import com.example.caseynelson.leaguearchitecture.di.ViewModelKey
import com.example.caseynelson.leaguearchitecture.ui.ChampionViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChampionViewModel::class)
    abstract fun bindChampionViewModel(championViewModel: ChampionViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}

