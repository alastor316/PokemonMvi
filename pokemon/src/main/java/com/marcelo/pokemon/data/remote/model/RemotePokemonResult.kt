package com.marcelo.pokemon.data.remote.model

import com.google.gson.annotations.SerializedName
import com.marcelo.pokemon.data.remote.model.Constants.NAME
import com.marcelo.pokemon.data.remote.model.Constants.SPRITES

data class RemotePokemonResult(
    @SerializedName(NAME) val name: String,
    @SerializedName(SPRITES) val remoteSprites: RemoteSprites?,
)