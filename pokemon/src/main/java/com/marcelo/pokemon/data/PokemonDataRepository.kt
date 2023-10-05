package com.marcelo.pokemon.data

import com.marcelo.pokemon.data.cache.model.CacheTransaction
import com.marcelo.pokemon.data.remote.model.RemotePokemonResult
import com.marcelo.pokemon.data.remote.model.RemotePokemonTypes
import com.marcelo.pokemon.data.remote.model.RemoteSprites
import com.marcelo.pokemon.data.source.PokemonCache
import com.marcelo.pokemon.data.source.PokemonRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class PokemonDataRepository @Inject constructor(
    private val cache: PokemonCache,
    private val remote: PokemonRemote
){
    fun getAllPokemon(): Flow<RemotePokemonTypes> = flow {
        val pokemonTypes = remote.getAllPokemon()
        emit(pokemonTypes)
    }

    fun savePokemonId(pokemonId: String) = runBlocking {
        val pokemonCache = CacheTransaction(pokemonId = pokemonId)
        cache.savePokemonId(pokemonCache)
    }

    fun getPokemonDetail(): Flow<RemotePokemonResult> = flow {
        val pokemonCache: CacheTransaction = cache.getPokemonId()
        val pokemon = remote.getPokemonDetail(pokemonCache.pokemonId)
        emit(pokemon)
    }
}