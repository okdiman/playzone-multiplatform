package login

import AuthRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject.instance
import kotlinx.coroutines.launch
import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState

class LoginViewModel : BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState(email = "", password = "")
) {
    private val authRepository = instance<AuthRepository>()

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.LoginClick -> sendLogin()
            is LoginEvent.EmailChanged -> handleEmailChanged(viewEvent.value)
            is LoginEvent.PasswordChanged -> handlePasswordChanged(viewEvent.value)
            is LoginEvent.RegistrationClick -> onRegistrationClick()
            is LoginEvent.ForgotClick -> onForgotClick()
            is LoginEvent.ShowPasswordClick -> changePasswordVisibility()
        }
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)
        viewModelScope.launch {
            viewState = try {
                val response = authRepository.login(viewState.email, viewState.password)
                if (response.token.isNotBlank()) {
                    viewState.copy(email = "", password = "", isSending = false)
                } else {
                    viewState.copy(isSending = false)
                }
            } catch (e: Exception) {
                viewState.copy(isSending = false)
            }
        }
    }

    private fun handleEmailChanged(newEmail: String) {
        viewState = viewState.copy(email = newEmail)
    }

    private fun handlePasswordChanged(newPassword: String) {
        viewState = viewState.copy(password = newPassword)
    }

    private fun onForgotClick() {
        viewAction = LoginAction.OpenForgotScreen
    }

    private fun onRegistrationClick() {
        viewAction = LoginAction.OpenRegistrationScreen
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(passwordHidden = !viewState.passwordHidden)
    }
}