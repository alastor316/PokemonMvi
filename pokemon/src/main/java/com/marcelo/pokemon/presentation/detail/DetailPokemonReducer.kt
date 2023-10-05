package com.marcelo.pokemon.presentation.detail

import com.marcelo.pokemon.presentation.detail.DetailPokemonResult.GetDetailPokemonResult
import com.marcelo.pokemon.utils.UnsupportedReduceException
import javax.inject.Inject

class DetailPokemonReducer @Inject constructor() {

    infix fun DetailPokemonUiState.reduceWith(result: DetailPokemonResult): DetailPokemonUiState {
        return when (val previousState = this) {
            is DetailPokemonUiState.DefaultUiState -> previousState reduceWith result
            is DetailPokemonUiState.LoadingUiState -> previousState reduceWith result
            is DetailPokemonUiState.DisplayDetailUiState -> previousState reduceWith result
            is DetailPokemonUiState.EmptyUiState -> previousState reduceWith result
            is DetailPokemonUiState.ErrorUiState -> previousState reduceWith result
        }
    }

    private infix fun DetailPokemonUiState.DefaultUiState.reduceWith(result: DetailPokemonResult): DetailPokemonUiState {
        return when (result) {
            GetDetailPokemonResult.InProgress -> DetailPokemonUiState.LoadingUiState
            else -> throw unsupportedReduceCase(this, result)
        }
    }

    private infix fun DetailPokemonUiState.LoadingUiState.reduceWith(result: DetailPokemonResult): DetailPokemonUiState {
        return when (result) {
            is GetDetailPokemonResult.Success -> DetailPokemonUiState.DisplayDetailUiState(
                pokemonResult = result.pokemonResult
            )
            GetDetailPokemonResult.Error -> DetailPokemonUiState.ErrorUiState
            else -> throw unsupportedReduceCase(this, result)
        }
    }

    private infix fun DetailPokemonUiState.EmptyUiState.reduceWith(result: DetailPokemonResult): DetailPokemonUiState {
        throw unsupportedReduceCase(this, result)
    }

    private infix fun DetailPokemonUiState.DisplayDetailUiState.reduceWith(result: DetailPokemonResult): DetailPokemonUiState {
        throw unsupportedReduceCase(this, result)
    }

    private infix fun DetailPokemonUiState.ErrorUiState.reduceWith(result: DetailPokemonResult): DetailPokemonUiState {
        return when (result) {
            GetDetailPokemonResult.InProgress -> DetailPokemonUiState.LoadingUiState
            else -> throw unsupportedReduceCase(this, result)
        }
    }


    private fun unsupportedReduceCase(
        uiState: DetailPokemonUiState,
        result: DetailPokemonResult
    ): Throwable {
        return UnsupportedReduceException(uiState, result)
    }
}