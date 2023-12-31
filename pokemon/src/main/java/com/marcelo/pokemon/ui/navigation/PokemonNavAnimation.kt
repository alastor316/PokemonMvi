package com.marcelo.pokemon.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

private const val DEFAULT_TWEEN = 300
private const val DEFAULT_OFFSET = 300

val enterTransition = slideInHorizontally(
    initialOffsetX = { DEFAULT_OFFSET },
    animationSpec = tween(DEFAULT_TWEEN)
) + fadeIn(animationSpec = tween(DEFAULT_TWEEN))

val exitTransition = slideOutHorizontally(
    targetOffsetX = { -DEFAULT_OFFSET },
    animationSpec = tween(DEFAULT_TWEEN)
) + fadeOut(animationSpec = tween(DEFAULT_TWEEN))

val popEnterTransition = slideInHorizontally(
    initialOffsetX = { -DEFAULT_OFFSET },
    animationSpec = tween(DEFAULT_TWEEN)
) + fadeIn(animationSpec = tween(DEFAULT_TWEEN))

val popExitTransition = slideOutHorizontally(
    targetOffsetX = { DEFAULT_OFFSET },
    animationSpec = tween(DEFAULT_TWEEN)
) + fadeOut(animationSpec = tween(DEFAULT_TWEEN))
