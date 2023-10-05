package com.marcelo.pokemon.presentation.detail

import com.marcelo.pokemon.mvibase.MviUserIntent

sealed class DetailPokemonUIntent : MviUserIntent {

    object InitialPokemonUIntent : DetailPokemonUIntent()

    object RetryPokemonDetailIntent : DetailPokemonUIntent()


}