package com.marcelo.pokemon.presentation.list

import com.marcelo.pokemon.mvibase.MviUserIntent

 sealed class ListPokemonUIntent : MviUserIntent {

    object InitialPokemonUIntent : ListPokemonUIntent()
    data class SavePokemonIdUIntent(val pokemonID: String) : ListPokemonUIntent()
}