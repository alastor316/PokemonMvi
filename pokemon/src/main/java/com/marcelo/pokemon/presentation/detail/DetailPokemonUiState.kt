package com.marcelo.pokemon.presentation.detail

import com.marcelo.pokemon.data.remote.model.RemotePokemonResult
import com.marcelo.pokemon.mvibase.MviUiState
import com.marcelo.pokemon.presentation.list.ListPokemonUiState
import com.marcelo.pokemon.presentation.model.Pokemon

sealed class DetailPokemonUiState : MviUiState {

    object DefaultUiState : DetailPokemonUiState()
    object LoadingUiState : DetailPokemonUiState()
    object EmptyUiState : DetailPokemonUiState()
    data class DisplayDetailUiState(val pokemonResult: RemotePokemonResult) : DetailPokemonUiState()
    object ErrorUiState : DetailPokemonUiState()
}
