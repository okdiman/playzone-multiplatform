package navigation

import NavigationTree
import forgotPassword.ForgotPasswordScreen
import login.LoginScreen
import register.RegisterScreen
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.authFlow() {
    flow(NavigationTree.Auth.AuthFlow.name) {
        screen(NavigationTree.Auth.Login.name) {
            LoginScreen()
        }
        screen(NavigationTree.Auth.Register.name) {
            RegisterScreen()
        }
        screen(NavigationTree.Auth.ForgotPassword.name) {
            ForgotPasswordScreen()
        }
    }
}