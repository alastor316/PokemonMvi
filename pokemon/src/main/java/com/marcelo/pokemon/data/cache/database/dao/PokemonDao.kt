package com.marcelo.pokemon.data.cache.database.dao

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.marcelo.pokemon.data.cache.database.config.TABLE_TRANSACTION
import com.marcelo.pokemon.data.cache.model.CacheTransaction

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonId(cacheTransaction: CacheTransaction)

    @Query("SELECT * FROM TABLE_TRANSACTION ORDER BY id DESC LIMIT 1")
    suspend fun getPokemonId(): CacheTransaction
}