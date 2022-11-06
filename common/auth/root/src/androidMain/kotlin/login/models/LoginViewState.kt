package login.models

data class LoginViewState(
    val email: String,
    val password: String,
    val passwordHidden: Boolean = true,
    val isSending: Boolean = false
)
