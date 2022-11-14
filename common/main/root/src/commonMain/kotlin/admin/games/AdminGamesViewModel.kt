package admin.games

import GamesRepository
import admin.games.models.AdminGamesAction
import admin.games.models.AdminGamesEvent
import admin.games.models.AdminGamesViewState
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject.instance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdminGamesViewModel :
    BaseSharedViewModel<AdminGamesViewState, AdminGamesAction, AdminGamesEvent>(
        initialState = AdminGamesViewState()
    ) {

    private val gamesRepository = instance<GamesRepository>()

    override fun obtainEvent(viewEvent: AdminGamesEvent) {
        when (viewEvent) {
            is AdminGamesEvent.AddNewGame -> {
                viewAction = AdminGamesAction.AddGamePressed
            }
            is AdminGamesEvent.ViewInitialized -> fetchAllGames()
        }
    }

    private fun fetchAllGames() {
        viewModelScope.launch(Dispatchers.Default) {
            val games = gamesRepository.fetchAllGames()
            viewState = viewState.copy(games = games)
        }
    }
}