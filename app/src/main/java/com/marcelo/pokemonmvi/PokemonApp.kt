package com.marcelo.pokemonmvi

import android.app.Application
import com.marcelo.pokemonmvi.di.AppComponent
import com.marcelo.pokemonmvi.di.DaggerAppComponent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokemonApp : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent(): AppComponent = DaggerAppComponent
        .factory()
        .create(applicationContext)
}