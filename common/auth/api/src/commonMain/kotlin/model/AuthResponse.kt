package model

import kotlin.jvm.JvmInline

@JvmInline
value class AuthResponse(
    val token: String
)