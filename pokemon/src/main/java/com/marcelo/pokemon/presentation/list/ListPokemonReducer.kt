package com.marcelo.pokemon.presentation.list

import com.marcelo.pokemon.presentation.list.ListPokemonResult.GetListPokemonResult
import com.marcelo.pokemon.presentation.list.ListPokemonUiState.*
import com.marcelo.pokemon.utils.UnsupportedReduceException
import javax.inject.Inject

class ListPokemonReducer @Inject constructor() {

   infix fun ListPokemonUiState.reduceWith(result: ListPokemonResult): ListPokemonUiState {
        return when (val previousState = this) {
            is DefaultUiState -> previousState reduceWith result
            is LoadingUiState -> previousState reduceWith result
            is DisplayListUiState -> previousState reduceWith result
            is EmptyUiState -> previousState reduceWith result
            is ErrorUiState -> previousState reduceWith result
        }
    }

    private infix fun DefaultUiState.reduceWith(result: ListPokemonResult): ListPokemonUiState {
        return when (result) {
            GetListPokemonResult.InProgress -> LoadingUiState
            else -> throw unsupportedReduceCase(this, result)
        }
    }

    private infix fun LoadingUiState.reduceWith(result: ListPokemonResult): ListPokemonUiState {
        return when (result) {
            GetListPokemonResult.Empty -> EmptyUiState
            is GetListPokemonResult.Success -> DisplayListUiState(pokemonTypes = result.lisPokemon)
            GetListPokemonResult.Error -> ErrorUiState
            else -> throw unsupportedReduceCase(this, result)
        }
    }

    private infix fun EmptyUiState.reduceWith(result: ListPokemonResult): ListPokemonUiState {
        throw unsupportedReduceCase(this, result)
    }

    private infix fun DisplayListUiState.reduceWith(result: ListPokemonResult): ListPokemonUiState {
        return when (result) {
            ListPokemonResult.SaveListPokemonResult.NavigateToDetail -> this
            else -> throw unsupportedReduceCase(this, result)
        }
    }

    private infix fun ErrorUiState.reduceWith(result: ListPokemonResult): ListPokemonUiState {
        return when (result) {
            GetListPokemonResult.InProgress -> LoadingUiState
            else -> throw unsupportedReduceCase(this, result)
        }
    }


    private fun unsupportedReduceCase(
        uiState: ListPokemonUiState,
        result: ListPokemonResult
    ): Throwable {
        return UnsupportedReduceException(uiState, result)
    }
}