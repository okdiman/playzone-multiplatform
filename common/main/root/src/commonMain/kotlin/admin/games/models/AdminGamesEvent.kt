package admin.games.models

sealed class AdminGamesEvent {
    object AddNewGame: AdminGamesEvent()
    object ViewInitialized: AdminGamesEvent()
}
