package com.marcelo.pokemon.data.remote.model

import com.google.gson.annotations.SerializedName
import com.marcelo.pokemon.data.remote.model.Constants.NAME
import com.marcelo.pokemon.data.remote.model.Constants.URL

data class RemotePokemon(
    @SerializedName(NAME) val name: String?,
    @SerializedName(URL) val url: String?,
)
