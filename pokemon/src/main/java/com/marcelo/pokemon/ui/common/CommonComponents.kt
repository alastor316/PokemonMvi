package com.marcelo.pokemon.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.marcelo.pokemon.ui.common.model.AttrsEmptyListTemplate
import com.marcelo.pokemon.ui.common.model.AttrsFullPageErrorTemplate
import com.marcelo.pokemon.ui.common.template.EmptyListTemplate
import com.marcelo.pokemon.ui.common.template.ErrorTemplate

/*@Composable
fun DefaultDisplayComponent() {
    Column { }
}

@Composable
fun LoadingComponent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorComponent(title: String, description: String, retryEvent: () -> Unit) {
    ErrorTemplate(
        attributes = AttrsFullPageErrorTemplate(
            title = title,
            description = description,
            btnName = "",
            icon = null,
            clickBtnListener = { retryEvent() }
        ),
        modifier = Modifier.fillMaxSize()
    )
}



@Composable
fun EmptyListComponent(title: String, description: String) {
    EmptyListTemplate(
        attributes = AttrsEmptyListTemplate(
            title = title,
            description = description,
            icon = null
        ),
        modifier = Modifier.fillMaxSize()
    )
}*/


