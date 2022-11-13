package login

import NavigationTree
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.models.LoginAction
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag

@Composable
fun LoginScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()
        LoginView(viewState = state.value) { event ->
            viewModel.obtainEvent(event)
        }

        when (action.value) {
            is LoginAction.OpenMainFlow -> {
                rootController.findRootController().present(
                    screen = NavigationTree.Main.Dashboard.name,
                    launchFlag = LaunchFlag.SingleNewTask
                )
            }
            is LoginAction.OpenForgotScreen -> {
                rootController.push(NavigationTree.Auth.ForgotPassword.name)
            }
            is LoginAction.OpenRegistrationScreen -> {
                rootController.push(NavigationTree.Auth.Register.name)
            }
            else -> {}
        }
    }
}