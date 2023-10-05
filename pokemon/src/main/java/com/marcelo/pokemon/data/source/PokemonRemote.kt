package com.marcelo.pokemon.data.source

import com.marcelo.pokemon.data.remote.model.RemotePokemonResult
import com.marcelo.pokemon.data.remote.model.RemotePokemonTypes

interface PokemonRemote {
    suspend fun getAllPokemon(): RemotePokemonTypes
    suspend fun getPokemonDetail(pokemonNumber: String): RemotePokemonResult
}