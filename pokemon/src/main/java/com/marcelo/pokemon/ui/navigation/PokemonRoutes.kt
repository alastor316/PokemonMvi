package com.marcelo.pokemon.ui.navigation

sealed class PokemonRoutes(val path: String){

    object ListPokemon : PokemonRoutes(path = "List")
    object Detail : PokemonRoutes(path = "Detail")
}
