package com.marcelo.pokemon.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.marcelo.pokemon.presentation.DetailPokemonViewModel
import com.marcelo.pokemon.presentation.ListPokemonViewModel
import com.marcelo.pokemon.ui.detail.DetailIntentHandler
import com.marcelo.pokemon.ui.detail.DetailPokemonScreen
import com.marcelo.pokemon.ui.list.ListPokemonIntentHandler
import com.marcelo.pokemon.ui.list.ListPokemonScreen

@OptIn(ExperimentalAnimationApi::class)
internal fun NavGraphBuilder.listPokemonNav(
    viewModel: ListPokemonViewModel,
    intentHandler: ListPokemonIntentHandler
) =
    composable(
        route = PokemonRoutes.ListPokemon.path,
        enterTransition = { enterTransition },
        exitTransition = { exitTransition },
        popEnterTransition = { popEnterTransition },
        popExitTransition = { popExitTransition }
    ) {
        val listUiState = remember {
            viewModel.processUserIntentsAndObserveUiStates(
                userIntents = intentHandler.userIntents()
            )
        }.collectAsState(initial = viewModel.defaultUiState)

        ListPokemonScreen(
            onPokemonClicked = { pokemonId ->
                intentHandler.emitPokemonDetailUIntent(pokemonId)
            },
            state = listUiState
        )
    }

@ExperimentalAnimationApi
internal fun NavGraphBuilder.detailPokemonNav(
    onBack: () -> Unit = {},
    viewModel: DetailPokemonViewModel,
    intentHandler: DetailIntentHandler
) = composable(
    route = PokemonRoutes.Detail.path,
    enterTransition = { enterTransition },
    exitTransition = { exitTransition },
    popEnterTransition = { popEnterTransition },
    popExitTransition = { popExitTransition }
) {
    val detailUiState = remember {
        viewModel.processUserIntentsAndObserveUiStates(
            userIntents = intentHandler.userIntents()
        )
    }.collectAsState(initial = viewModel.defaultUiState)

    DetailPokemonScreen(onBack = { onBack() }, state = detailUiState)
}
