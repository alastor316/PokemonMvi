package com.marcelo.pokemon.presentation.list

import com.marcelo.pokemon.mvibase.MviUiState
import com.marcelo.pokemon.presentation.model.Pokemon

sealed class ListPokemonUiState : MviUiState {

    object DefaultUiState : ListPokemonUiState()
    object LoadingUiState : ListPokemonUiState()
    object EmptyUiState : ListPokemonUiState()
    data class DisplayListUiState(val pokemonTypes: List<Pokemon>) : ListPokemonUiState()
    object ErrorUiState : ListPokemonUiState()
}
