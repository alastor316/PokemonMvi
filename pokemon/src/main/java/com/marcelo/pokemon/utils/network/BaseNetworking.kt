package com.marcelo.pokemon.utils.network

abstract class BaseNetworking {

    open fun getPinCertificatesConfig(): BasePinCertificatesConfig? {
        return null
    }

    open fun getCertSSL(): Int {
        return 0
    }

    open fun getCertPassword(): CharArray? {
        return null
    }

    abstract fun getHostname(): String?
}