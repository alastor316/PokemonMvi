package com.marcelo.pokemon.ui.list

import com.marcelo.pokemon.presentation.list.ListPokemonUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListPokemonIntentHandler @Inject constructor() {

    private val userIntents = MutableSharedFlow<ListPokemonUIntent>()
    var coroutineScope: CoroutineScope? = null

    internal fun userIntents(): Flow<ListPokemonUIntent> = merge(
        flow { emit(ListPokemonUIntent.InitialPokemonUIntent) },
        userIntents.asSharedFlow()
    )

    internal fun emitPokemonDetailUIntent(pokemonId: String) {
        coroutineScope?.launch {
            userIntents.emit(ListPokemonUIntent.SavePokemonIdUIntent(pokemonId))
        }
    }
}