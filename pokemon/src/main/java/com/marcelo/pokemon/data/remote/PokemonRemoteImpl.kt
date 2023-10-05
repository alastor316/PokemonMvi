package com.marcelo.pokemon.data.remote

import com.marcelo.pokemon.data.remote.model.RemotePokemonResult
import com.marcelo.pokemon.data.remote.model.RemotePokemonTypes
import com.marcelo.pokemon.data.remote.retrofit.PokemonWebService
import com.marcelo.pokemon.data.source.PokemonRemote
import javax.inject.Inject

class PokemonRemoteImpl @Inject constructor(
    private val webService: PokemonWebService
) : PokemonRemote {

    override suspend fun getAllPokemon(): RemotePokemonTypes =
        webService.getAllPokemon()

    override suspend fun getPokemonDetail(pokemonNumber: String):RemotePokemonResult =
        webService.getPokemonDetail(pokemonNumber)

}

