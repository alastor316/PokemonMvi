package com.marcelo.pokemon.ui.common.model

import android.graphics.drawable.Drawable

data class AttrsFullPageErrorTemplate(
    val title: String = "",
    val description: String = "",
    val btnName: String ="",
    val icon: Drawable? = null,
    val clickBtnListener: () -> Unit = {}
)
