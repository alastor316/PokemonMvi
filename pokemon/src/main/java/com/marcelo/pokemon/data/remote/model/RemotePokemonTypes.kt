package com.marcelo.pokemon.data.remote.model

import com.google.gson.annotations.SerializedName
import com.marcelo.pokemon.data.remote.model.Constants.POKEMON_TYPES

data class RemotePokemonTypes(
    @SerializedName(POKEMON_TYPES) val remotePokemonTypes: List<RemotePokemon>?
)
