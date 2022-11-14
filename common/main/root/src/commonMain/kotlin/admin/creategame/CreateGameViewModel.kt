package admin.creategame

import AuthRepository
import GamesRepository
import admin.creategame.models.CreateGameAction
import admin.creategame.models.CreateGameEvent
import admin.creategame.models.CreateGameViewState
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject.instance
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import models.CreateGameInfo

class CreateGameViewModel :
    BaseSharedViewModel<CreateGameViewState, CreateGameAction, CreateGameEvent>(
        initialState = CreateGameViewState()
    ) {

    private val authRepository = instance<AuthRepository>()
    private val gamesRepository = instance<GamesRepository>()

    override fun obtainEvent(viewEvent: CreateGameEvent) {
        when (viewEvent) {
            is CreateGameEvent.TitleChanged -> viewState = viewState.copy(title = viewEvent.value)
            is CreateGameEvent.DescriptionChanged -> viewState =
                viewState.copy(description = viewEvent.value)
            is CreateGameEvent.VersionChanged -> viewState =
                viewState.copy(version = viewEvent.value)
            is CreateGameEvent.SizeChanged -> viewState = viewState.copy(size = viewEvent.value)
            is CreateGameEvent.SubmitCreation -> createGame()
        }
    }

    private fun createGame() {
        viewModelScope.launch(Dispatchers.Default) {
            viewState = viewState.copy(isSending = true)
            try {
                val token = authRepository.fetchToken()
                gamesRepository.createGame(
                    token, CreateGameInfo(
                        title = viewState.title,
                        description = viewState.description,
                        version = viewState.version,
                        size = viewState.size.toDouble()
                    )
                )
                viewAction = CreateGameAction.CloseScreen
            } catch (e: IOException) {
                viewState = viewState.copy(isSending = false)
            }
        }
    }
}