package com.marcelo.pokemon.presentation.list.mapper

import com.marcelo.pokemon.data.remote.model.RemotePokemon
import com.marcelo.pokemon.presentation.model.Pokemon


fun List<RemotePokemon>.toPokemonType() = map { remoteAccount ->
    remoteAccount.toPokemon()
}

private fun RemotePokemon.toPokemon() = Pokemon(
    name = name.orEmpty(),
    url = url.orEmpty()
)