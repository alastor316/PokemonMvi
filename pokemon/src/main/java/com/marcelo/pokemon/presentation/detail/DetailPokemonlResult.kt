package com.marcelo.pokemon.presentation.detail

import com.marcelo.pokemon.data.remote.model.RemotePokemonResult
import com.marcelo.pokemon.mvibase.MviResult

sealed class DetailPokemonResult : MviResult {

    sealed class GetDetailPokemonResult : DetailPokemonResult() {
        object InProgress : GetDetailPokemonResult()
        data class Success(val pokemonResult: RemotePokemonResult) : GetDetailPokemonResult()
        object Empty : GetDetailPokemonResult()
        object Error : GetDetailPokemonResult()
    }
}
