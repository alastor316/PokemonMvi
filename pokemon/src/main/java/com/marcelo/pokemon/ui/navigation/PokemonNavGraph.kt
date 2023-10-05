package com.marcelo.pokemon.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.marcelo.pokemon.di.PokemonComponentProvider
import com.marcelo.pokemon.presentation.DetailPokemonViewModel
import com.marcelo.pokemon.presentation.ListPokemonViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@Composable
fun PokemonNavGraph(
    fragmentActivity: FragmentActivity,
    startDestination: String = PokemonRoutes.ListPokemon.path
) {

    val navController = rememberAnimatedNavController()
    val navActions = remember(navController) { PokemonNavActions(navController) }

    val pokemonComponent =
        (fragmentActivity as PokemonComponentProvider).providePokemonComponent()
    val viewModelFactory = pokemonComponent.getViewModelFactory()
    val coroutineScope = rememberCoroutineScope()

    val listViewModel: ListPokemonViewModel = viewModel<ListPokemonViewModel>(
        factory =  viewModelFactory
    ).apply {
        this.navActions = navActions
    }

    val pokemonIntentHandler = pokemonComponent.getListIntentHandler().apply {
        this.coroutineScope = coroutineScope
    }

    val detailViewModel: DetailPokemonViewModel = viewModel<DetailPokemonViewModel>(
        factory = viewModelFactory
    ).apply {
        this.navActions = navActions
    }

    val detailIntentHandler = pokemonComponent.getDetailIntentHandler().apply {
        this.coroutineScope = coroutineScope
    }

    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        listPokemonNav(
            viewModel = listViewModel,
            intentHandler = pokemonIntentHandler
        )

        detailPokemonNav(
            onBack = { fragmentActivity.finish() },
            intentHandler = detailIntentHandler,
            viewModel = detailViewModel
        )
    }



}