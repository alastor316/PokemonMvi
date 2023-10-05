package com.marcelo.pokemon.ui.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.marcelo.pokemon.data.remote.model.RemotePokemonResult
import com.marcelo.pokemon.presentation.detail.DetailPokemonUiState
import com.marcelo.pokemon.ui.composables.DefaultDisplayComponent
import com.marcelo.pokemon.ui.composables.LoadingComponent
import com.marcelo.pokemon.ui.list.PokemonListScreenTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
internal fun DetailPokemonScreen(
    onBack: () -> Unit = {},
    state: State<DetailPokemonUiState>
) {
    Scaffold(
        topBar = { PokemonListScreenTopBar() },
    ) {
        DetailPokemonContent(
            uiState = state
        )
    }
}

@Composable
fun DetailPokemonContent(uiState: State<DetailPokemonUiState>) {
    when (val currentState = uiState.value) {
        DetailPokemonUiState.DefaultUiState -> DefaultDisplayComponent()
        DetailPokemonUiState.LoadingUiState -> LoadingComponent()
        is DetailPokemonUiState.DisplayDetailUiState -> {
            DisplayDetailComponent(currentState.pokemonResult)
        }
        DetailPokemonUiState.ErrorUiState -> {

        }
        else -> {}
    }
}


@Composable
fun DisplayDetailComponent(pokemonResult: RemotePokemonResult) {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Box(
                Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(pokemonResult.remoteSprites?.frontDefault),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "Background Image",
                    contentScale = ContentScale.Crop
                )
                Text(pokemonResult.name, Modifier.padding(16.dp))
            }
        }
    }
}


