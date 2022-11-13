package home

import com.adeo.kviewmodel.BaseSharedViewModel
import home.models.HomeAction
import home.models.HomeEvent
import home.models.HomeViewState
import kotlinx.coroutines.launch

class HomeViewModel : BaseSharedViewModel<HomeViewState, HomeAction, HomeEvent>(
    initialState = HomeViewState(
        userName = "Dmitrii Okunev",
        avatarUrl = "https://ss.sport-express.ru/userfiles/materials/180/1808815/volga.jpg",
        status = "Morning"
    )
) {
    override fun obtainEvent(viewEvent: HomeEvent) {
        when (viewEvent) {
            is HomeEvent.UserProfileClicked -> onUserProfileClicked()
        }
    }

    private fun onUserProfileClicked() {
        viewModelScope.launch {
            viewAction = HomeAction.ShowUserProfile
        }
    }
}