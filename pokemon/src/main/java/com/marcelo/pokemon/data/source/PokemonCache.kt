package com.marcelo.pokemon.data.source

import com.marcelo.pokemon.data.cache.model.CacheTransaction

interface PokemonCache {

    suspend fun savePokemonId(cacheTransaction: CacheTransaction)

    suspend fun getPokemonId(): CacheTransaction
}