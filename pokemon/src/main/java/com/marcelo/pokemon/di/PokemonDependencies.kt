package com.marcelo.pokemon.di

import android.content.Context
import com.marcelo.pokemon.utils.InterceptorParams

data class PokemonDependencies(
    val interceptorParams: InterceptorParams,
    val flavorName: String,
    val isDebug: Boolean,
    val context: Context
)



