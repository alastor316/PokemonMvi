package com.marcelo.pokemon.di

import androidx.lifecycle.ViewModelProvider
import com.marcelo.pokemon.ui.detail.DetailIntentHandler
import com.marcelo.pokemon.ui.list.ListPokemonIntentHandler
import dagger.Binds
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


@FlowPreview
@ExperimentalCoroutinesApi
@Subcomponent(
    modules = [
        RemoteModule::class,
        PresentationModule::class,
        NetWorkModule::class,
        CacheModule::class
  //      DatabaseModule::class
    ]
)

interface PokemonSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance pokemonDependencies: PokemonDependencies
        ): PokemonSubcomponent
    }


    fun getViewModelFactory(): ViewModelProvider.Factory

    fun getListIntentHandler(): ListPokemonIntentHandler

    fun getDetailIntentHandler(): DetailIntentHandler


}

