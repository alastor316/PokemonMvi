package com.marcelo.pokemon.di

import com.marcelo.pokemon.data.remote.PokemonRemoteImpl
import com.marcelo.pokemon.data.source.PokemonRemote
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun bindDigitalCollectionRemote(remote: PokemonRemoteImpl): PokemonRemote

}

