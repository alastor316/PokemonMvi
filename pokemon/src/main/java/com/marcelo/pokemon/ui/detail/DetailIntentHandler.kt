package com.marcelo.pokemon.ui.detail

import com.marcelo.pokemon.presentation.detail.DetailPokemonUIntent
import com.marcelo.pokemon.presentation.detail.DetailPokemonUIntent.InitialPokemonUIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailIntentHandler @Inject constructor() {

    private val userIntents = MutableSharedFlow<DetailPokemonUIntent>()
    var coroutineScope: CoroutineScope? = null


    internal fun userIntents(): Flow<DetailPokemonUIntent> = merge(
        flow { emitSeeDetailInitialUIntent() },
        userIntents.asSharedFlow()
    )

    private suspend fun FlowCollector<DetailPokemonUIntent>.emitSeeDetailInitialUIntent() {
        emit(InitialPokemonUIntent)
    }

    internal fun emitRetryDetailUIntent() {
        coroutineScope?.launch {
            userIntents.emit(InitialPokemonUIntent)
        }
    }
}