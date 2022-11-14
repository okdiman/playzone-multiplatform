package data.sqldelight

import com.okunev_dmitrii.playzone_mobile.Database
import data.ktor.KtorSearchGame

class SqlDelightGamesDataSource(
    private val database: Database
) {
    fun fetchLocalGames() = database.gameQueries.getAllGames().executeAsList()

    fun insertGame(game: KtorSearchGame) {
        database.gameQueries.insertGame(
            game_id = game.gameId,
            game_title = game.title,
            game_size = game.size,
            game_version = game.version
        )
    }
}