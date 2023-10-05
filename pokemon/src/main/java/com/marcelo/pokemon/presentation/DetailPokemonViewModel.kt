package com.marcelo.pokemon.presentation

import androidx.lifecycle.ViewModel
import com.marcelo.pokemon.presentation.detail.DetailPokemonAction
import com.marcelo.pokemon.presentation.detail.DetailPokemonAction.*
import com.marcelo.pokemon.presentation.detail.DetailPokemonReducer
import com.marcelo.pokemon.presentation.detail.DetailPokemonUIntent
import com.marcelo.pokemon.presentation.detail.DetailPokemonUIntent.RetryPokemonDetailIntent
import com.marcelo.pokemon.presentation.detail.DetailPokemonUiState
import com.marcelo.pokemon.presentation.detail.DetailPokemonProcessor
import com.marcelo.pokemon.ui.navigation.PokemonNavActions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.scan
import javax.inject.Inject


class DetailPokemonViewModel @Inject constructor(
    private val reducer: DetailPokemonReducer,
    private val processor: DetailPokemonProcessor
) : ViewModel() {

    val defaultUiState: DetailPokemonUiState = DetailPokemonUiState.DefaultUiState

    var navActions: PokemonNavActions? = null

    fun processUserIntentsAndObserveUiStates(userIntents: Flow<DetailPokemonUIntent>): Flow<DetailPokemonUiState> =
        userIntents.buffer()
            .flatMapMerge { userIntent ->
                processor.actionProcessor(userIntent.toAction())
            }
            .scan(defaultUiState) { previousUiState, result ->
                with(reducer) { previousUiState reduceWith result }
            }


    private fun DetailPokemonUIntent.toAction(): DetailPokemonAction {
        return when (this) {
            DetailPokemonUIntent.InitialPokemonUIntent, RetryPokemonDetailIntent -> GetDetailsPokemonAction
        }
    }
}
