package com.marcelo.pokemon.data.remote.model

import com.google.gson.annotations.SerializedName

data class RemoteSprites(
    @SerializedName(Constants.IMAGE_URL) val frontDefault: String?,
)
