package com.marcelo.pokemon.presentation.list

import com.marcelo.pokemon.data.PokemonDataRepository
import com.marcelo.pokemon.presentation.list.ListPokemonAction.GetListPokemonAction
import com.marcelo.pokemon.presentation.list.ListPokemonResult.GetListPokemonResult
import com.marcelo.pokemon.presentation.list.ListPokemonResult.SaveListPokemonResult
import com.marcelo.pokemon.presentation.list.mapper.toPokemonType
import com.marcelo.pokemon.utils.ExecutionThread
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class ListPokemonProcessor @Inject constructor(
    private val repository: PokemonDataRepository,
    private val coroutineThreadProvider: ExecutionThread){

    fun actionProcessor(actions: ListPokemonAction): Flow<ListPokemonResult> =
        when (actions) {
            GetListPokemonAction -> getListProcessor()
            is ListPokemonAction.SavePokemonIdAction -> savePokemonProcessor(actions.pokemonID)
        }

    private fun getListProcessor(): Flow<GetListPokemonResult> =
        repository.getAllPokemon()
            .map { remoteListPokemon ->
                val listPokemon = remoteListPokemon.remotePokemonTypes
                if (listPokemon != null && listPokemon.isNotEmpty()) {
                    GetListPokemonResult.Success( listPokemon.toPokemonType())
                } else {
                    GetListPokemonResult.Empty
                }
            }.onStart {
                emit(GetListPokemonResult.InProgress)
            }.catch {
                emit(GetListPokemonResult.Error)
            }
            .flowOn(coroutineThreadProvider.ioThread)

    private fun savePokemonProcessor(pokemonID: String): Flow<SaveListPokemonResult> = flow {
        repository.savePokemonId(pokemonID)
        emit(SaveListPokemonResult.NavigateToDetail)
    }
}

