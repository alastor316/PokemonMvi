package com.marcelo.pokemon.data.remote.retrofit

import com.marcelo.pokemon.data.remote.model.Constants.POKEMON_NUMBER
import com.marcelo.pokemon.data.remote.model.RemotePokemonResult
import com.marcelo.pokemon.data.remote.model.RemotePokemonTypes
import com.marcelo.pokemon.utils.ApiServiceInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonWebService {
    @GET("api/v2/pokemon")
    suspend fun getAllPokemon(): RemotePokemonTypes

    @GET("api/v2/pokemon/{$POKEMON_NUMBER}")
    suspend fun getPokemonDetail(@Path(POKEMON_NUMBER) pokemonNumber: String): RemotePokemonResult
}



