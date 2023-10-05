package com.marcelo.pokemon.utils

import kotlinx.coroutines.CoroutineDispatcher

interface ExecutionThread {
    val ioThread: CoroutineDispatcher
    val mainThread: CoroutineDispatcher
    val unconfinedThread: CoroutineDispatcher
}