package com.marcelo.pokemon.utils

import com.marcelo.pokemon.mvibase.MviResult
import com.marcelo.pokemon.mvibase.MviUiState
import com.marcelo.pokemon.presentation.list.ListPokemonResult
import com.marcelo.pokemon.presentation.list.ListPokemonUiState

class UnsupportedReduceException(state: MviUiState, result: MviResult) :
    RuntimeException("Cannot reduce state: $state with result: $result")