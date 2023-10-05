package com.marcelo.pokemon.ui.navigation

import androidx.navigation.NavHostController

class PokemonNavActions(navHostController: NavHostController) {

    val detail: () -> Unit = {
        navHostController.navigate(PokemonRoutes.Detail.path)
    }

    val upPress: () -> Unit = {
        navHostController.navigateUp()
    }

    val popBackStack: () -> Unit = {
        navHostController.popBackStack()
    }
}

