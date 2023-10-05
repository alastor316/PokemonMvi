package com.marcelo.pokemon.di

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
interface PokemonComponentProvider {
    fun providePokemonComponent(): PokemonSubcomponent
}