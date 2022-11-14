package admin.creategame.models

sealed class CreateGameAction {
    object CloseScreen : CreateGameAction()
}
