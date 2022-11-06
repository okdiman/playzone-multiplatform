package ktor

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.AuthResponse

@Serializable
data class KtorAuthResponse(
    @SerialName("token") val token: String
)

fun KtorAuthResponse.mapToDomain(): AuthResponse = AuthResponse(token)