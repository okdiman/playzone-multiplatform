package login.models

sealed class LoginAction {
    object OpenRegistrationScreen : LoginAction()
    object OpenForgotScreen : LoginAction()
    object OpenMainFlow : LoginAction()
}
