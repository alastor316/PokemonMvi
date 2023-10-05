package com.marcelo.pokemon.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.marcelo.pokemon.data.cache.database.config.TABLE_TRANSACTION
import com.marcelo.pokemon.data.remote.model.Constants.ID
import com.marcelo.pokemon.data.remote.model.Constants.POKEMON_ID

@Entity(tableName = TABLE_TRANSACTION)
data class CacheTransaction (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    val id: Int = 0,
    @ColumnInfo(name = POKEMON_ID)
    val pokemonId: String,
)