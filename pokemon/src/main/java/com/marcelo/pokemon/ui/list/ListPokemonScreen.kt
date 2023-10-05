@file:OptIn(ExperimentalCoilApi::class)

package com.marcelo.pokemon.ui.list

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.marcelo.pokemon.presentation.list.ListPokemonUiState
import com.marcelo.pokemon.presentation.list.ListPokemonUiState.DefaultUiState
import com.marcelo.pokemon.presentation.list.ListPokemonUiState.DisplayListUiState
import com.marcelo.pokemon.presentation.list.ListPokemonUiState.ErrorUiState
import com.marcelo.pokemon.presentation.model.Pokemon
import com.marcelo.pokemon.ui.composables.BackNavigationIcon
import com.marcelo.pokemon.ui.composables.DefaultDisplayComponent
import com.marcelo.pokemon.ui.composables.LoadingComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


private const val GRID_SPAN_COUNT = 3

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@FlowPreview
@ExperimentalCoroutinesApi
@Composable
internal fun ListPokemonScreen(
    state: State<ListPokemonUiState>,
    onPokemonClicked: (String) -> Unit
) {
    Scaffold(
        topBar = { PokemonListScreenTopBar() },
    ) {
        ListPokemonContent(
            onPokemonClicked = { onPokemonClicked(it) },
            uiState = state
        )
    }
}


@ExperimentalCoroutinesApi
@FlowPreview
@Composable
private fun ListPokemonContent(
    uiState: State<ListPokemonUiState>,
    onPokemonClicked: (String) -> Unit
    ) {
    when (val currentState = uiState.value) {
        DefaultUiState -> DefaultDisplayComponent()
        ListPokemonUiState.LoadingUiState -> LoadingComponent()
        //   ListPokemonUiState.EmptyUiState -> EmptyListComponent()*/
        is DisplayListUiState -> DisplayListComponent(
            currentState.pokemonTypes,
            onPokemonClicked = {
                onPokemonClicked(it)
            }
        )

        else -> {}
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun DisplayListComponent(
    pokemonTypes: List<Pokemon>,
    onPokemonClicked: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(GRID_SPAN_COUNT),
        content = {
            items(pokemonTypes) { pokemon ->
                Log.d("pokemonRes", pokemon.getImageUrl())
                PokemonGridItem(pokemon = pokemon, onPokemonClicked =  { onPokemonClicked(it) })
            }
        }
    )

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonGridItem(
    pokemon: Pokemon,
    onPokemonClicked: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .height(100.dp)
            .width(100.dp),
        onClick = {
            onPokemonClicked(pokemon.getUrlNumber())
        },
        shape = RoundedCornerShape(4.dp)
    ) {
        Image(
            painter = rememberImagePainter(pokemon.getImageUrl()),
            contentDescription = null,
            modifier = Modifier.background(Color.White)
        )
    }
}

@Composable
fun PokemonListScreenTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Pokemon App",
                textAlign = TextAlign.Center,
            )
        },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        //  navigationIcon = { BackNavigationIcon(onClick) }
    )
}





