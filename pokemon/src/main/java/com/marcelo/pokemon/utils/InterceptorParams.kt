package com.marcelo.pokemon.utils

import okhttp3.Interceptor

data class InterceptorParams(
    val tokenInterceptor: Interceptor,
    val unauthorizedInterceptor: Interceptor,
)
