package com.marcelo.pokemon.data.cache

import com.marcelo.pokemon.data.cache.database.dao.PokemonDao
import com.marcelo.pokemon.data.cache.model.CacheTransaction
import com.marcelo.pokemon.data.source.PokemonCache
import javax.inject.Inject

class PokemonCacheImpl @Inject constructor(
    private val pokemonDao: PokemonDao
): PokemonCache {

    override suspend fun savePokemonId(cacheTransaction: CacheTransaction) =
        pokemonDao.insertPokemonId(cacheTransaction)

    override suspend fun getPokemonId(): CacheTransaction =
        pokemonDao.getPokemonId()

}