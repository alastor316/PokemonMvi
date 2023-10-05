package com.marcelo.pokemon.presentation

import androidx.lifecycle.ViewModel
import com.marcelo.pokemon.presentation.list.ListPokemonAction
import com.marcelo.pokemon.presentation.list.ListPokemonAction.*
import com.marcelo.pokemon.presentation.list.ListPokemonReducer
import com.marcelo.pokemon.presentation.list.ListPokemonResult
import com.marcelo.pokemon.presentation.list.ListPokemonResult.*
import com.marcelo.pokemon.presentation.list.ListPokemonProcessor
import com.marcelo.pokemon.presentation.list.ListPokemonUIntent
import com.marcelo.pokemon.presentation.list.ListPokemonUIntent.InitialPokemonUIntent
import com.marcelo.pokemon.presentation.list.ListPokemonUIntent.SavePokemonIdUIntent
import com.marcelo.pokemon.presentation.list.ListPokemonUiState
import com.marcelo.pokemon.ui.navigation.PokemonNavActions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan
import javax.inject.Inject

class ListPokemonViewModel @Inject constructor(
    private val reducer: ListPokemonReducer,
    private val processor: ListPokemonProcessor
) : ViewModel() {

    val defaultUiState: ListPokemonUiState = ListPokemonUiState.DefaultUiState

    var navActions: PokemonNavActions? = null

      fun processUserIntentsAndObserveUiStates(userIntents: Flow<ListPokemonUIntent>): Flow<ListPokemonUiState> =
          userIntents.buffer()
               .flatMapMerge { userIntent ->
                    processor.actionProcessor(userIntent.toAction())
               }
               .checkResultForNav()
               .scan(defaultUiState) { previousUiState, result ->
                    with(reducer) { previousUiState reduceWith result }
               }


    private fun ListPokemonUIntent.toAction(): ListPokemonAction {
        return when (this) {
            is InitialPokemonUIntent -> GetListPokemonAction
            is SavePokemonIdUIntent -> SavePokemonIdAction(pokemonID = pokemonID)
        }
    }

    private fun Flow<ListPokemonResult>.checkResultForNav(): Flow<ListPokemonResult> =
        onEach { result ->
            when (result) {
                GetListPokemonResult.Error -> navigateToDetailPokemon()
                SaveListPokemonResult.NavigateToDetail -> navigateToDetailPokemon()
                else -> return@onEach
            }
        }

    private fun navigateToDetailPokemon() {
        navActions?.detail?.invoke()
    }
}