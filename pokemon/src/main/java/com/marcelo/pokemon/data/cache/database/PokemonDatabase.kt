package com.marcelo.pokemon.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marcelo.pokemon.data.cache.database.dao.PokemonDao
import com.marcelo.pokemon.data.cache.model.CacheTransaction

@Database(entities = [CacheTransaction::class], version = 1)
abstract class PokemonDatabase : RoomDatabase()
{
    abstract fun pokemonDao(): PokemonDao
}