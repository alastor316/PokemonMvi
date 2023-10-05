package com.marcelo.pokemon.utils.network

import javax.inject.Inject

class ApiNetworking : BaseNetworking() {


    override fun getHostname(): String? {
        return "https://pokeapi.co/"
    }

}