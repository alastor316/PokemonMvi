package com.marcelo.pokemon.presentation.list

import com.marcelo.pokemon.mvibase.MviAction

sealed class ListPokemonAction: MviAction {
    object GetListPokemonAction : ListPokemonAction()
    data class SavePokemonIdAction(val pokemonID: String) : ListPokemonAction()
}
