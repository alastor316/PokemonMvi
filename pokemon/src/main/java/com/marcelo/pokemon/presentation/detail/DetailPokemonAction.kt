package com.marcelo.pokemon.presentation.detail

import com.marcelo.pokemon.mvibase.MviAction

sealed class DetailPokemonAction :MviAction {
    object GetDetailsPokemonAction : DetailPokemonAction()
}
