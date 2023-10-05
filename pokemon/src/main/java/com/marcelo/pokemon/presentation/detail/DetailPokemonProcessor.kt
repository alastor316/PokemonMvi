package com.marcelo.pokemon.presentation.detail

import com.marcelo.pokemon.data.PokemonDataRepository
import com.marcelo.pokemon.presentation.detail.DetailPokemonAction.GetDetailsPokemonAction
import com.marcelo.pokemon.presentation.detail.DetailPokemonResult.GetDetailPokemonResult
import com.marcelo.pokemon.utils.ExecutionThread
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class DetailPokemonProcessor @Inject constructor(
    private val repository: PokemonDataRepository,
    private val coroutineThreadProvider: ExecutionThread) {

    fun actionProcessor(actions: DetailPokemonAction): Flow<DetailPokemonResult> =
        when (actions) {
            GetDetailsPokemonAction -> getDetailProcessor()
        }

    private fun getDetailProcessor(): Flow<DetailPokemonResult> =
        repository.getPokemonDetail()
            .map { pokemonResult ->
                GetDetailPokemonResult.Success(pokemonResult) as DetailPokemonResult
            }.onStart {
                emit(GetDetailPokemonResult.InProgress)
            }.catch {
                emit(GetDetailPokemonResult.Error)
            }
            .flowOn(coroutineThreadProvider.ioThread)

}