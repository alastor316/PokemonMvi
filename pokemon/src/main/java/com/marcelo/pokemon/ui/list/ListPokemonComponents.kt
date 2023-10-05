package com.marcelo.pokemon.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.marcelo.pokemon.presentation.model.Pokemon

/*
@Composable
internal fun DisplayPokemonListComponent(
    onDetailEvent: (String) -> Unit,
    pokemonTypes: List<Pokemon>
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(
                start = 36.dp,
                end = 36.dp,
            )
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        pokemonTypes.forEach { pokemon ->
            pokemon.name
        }

    }
}*/
