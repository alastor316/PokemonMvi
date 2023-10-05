package com.marcelo.pokemon.presentation.list

import com.marcelo.pokemon.mvibase.MviResult
import com.marcelo.pokemon.presentation.model.Pokemon

sealed class ListPokemonResult : MviResult {
    sealed class GetListPokemonResult : ListPokemonResult() {
        object InProgress : GetListPokemonResult()
        data class Success(val lisPokemon: List<Pokemon>) : GetListPokemonResult()
        object Empty : GetListPokemonResult()
        object Error : GetListPokemonResult()
    }

    sealed class SaveListPokemonResult : ListPokemonResult() {
        object NavigateToDetail : SaveListPokemonResult()
    }
}
