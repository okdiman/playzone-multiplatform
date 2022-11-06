package ktor

import kotlinx.serialization.Serializable

@Serializable
data class KtorAuthRequest(
    val login: String,
    val password: String
)