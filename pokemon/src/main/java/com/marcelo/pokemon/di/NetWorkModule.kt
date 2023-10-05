package com.marcelo.pokemon.di

import com.marcelo.pokemon.data.remote.PokemonRemoteImpl
import com.marcelo.pokemon.data.remote.retrofit.PokemonWebService
import com.marcelo.pokemon.utils.ExecutionThread
import com.marcelo.pokemon.utils.ExecutionThreadImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetWorkModule {

    @Provides
    fun provideExecutionThread(): ExecutionThread = ExecutionThreadImpl()

    @Provides
    fun ProvideRepository(remote: PokemonWebService) = PokemonRemoteImpl(remote)

    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create(PokemonWebService::class.java)

    @Provides
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}