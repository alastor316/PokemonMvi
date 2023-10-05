package com.marcelo.pokemonmvi.di

import com.marcelo.pokemon.di.PokemonSubcomponent
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
@InstallIn(SingletonComponent::class)
@Module(subcomponents = [PokemonSubcomponent::class])
class SubcomponentsModule