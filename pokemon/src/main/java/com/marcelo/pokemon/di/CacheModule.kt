package com.marcelo.pokemon.di

import android.content.Context
import androidx.room.Room
import com.marcelo.pokemon.data.cache.PokemonCacheImpl
import com.marcelo.pokemon.data.cache.database.PokemonDatabase
import com.marcelo.pokemon.data.source.PokemonCache
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

    @Binds
    abstract fun bindPokemonCache(cache: PokemonCacheImpl): PokemonCache


    companion object {

        @Provides
        fun providePokemonDao(db: PokemonDatabase) = db.pokemonDao()

        @Provides
        fun provideAppDatabase(appContext: Context): PokemonDatabase {
            return Room
                .databaseBuilder(appContext, PokemonDatabase::class.java, "pokemon.db")
                .build()
        }

    }
}