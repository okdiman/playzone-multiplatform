package search

import GamesRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject.instance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import search.models.SearchAction
import search.models.SearchEvent
import search.models.SearchViewState

class SearchViewModel : BaseSharedViewModel<SearchViewState, SearchAction, SearchEvent>(
    initialState = SearchViewState()
) {

    private val gamesRepository = instance<GamesRepository>()
    private var searchJob: Job? = null

    override fun obtainEvent(viewEvent: SearchEvent) {
        when (viewEvent) {
            is SearchEvent.GameClicked -> openClickedGame()
            is SearchEvent.QueryChanged -> searchGame(viewEvent.query)
        }
    }

    private fun openClickedGame() {
        viewAction = SearchAction.ShowGameDetail
    }

    private fun searchGame(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch(Dispatchers.Default) {
            viewState = viewState.copy(query = query)
            delay(500)
            val games = gamesRepository.searchGame(query)
            viewState = try {
                viewState.copy(games = games)
            } catch (e: Exception) {
                viewState.copy(games = emptyList())
            }
        }
    }
}