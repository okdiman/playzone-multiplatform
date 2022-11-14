package data.repo

import GamesRepository
import data.ktor.KtorGamesDataSource
import data.ktor.mapToDomain
import data.sqldelight.SqlDelightGamesDataSource
import models.CreateGameInfo
import models.Game

class GamesRepositoryImpl(
    private val remoteDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource
) : GamesRepository {
    override suspend fun fetchAllGames(): List<Game> {
        val localGames = localDataSource.fetchLocalGames()
            .map {
                Game(gameId = it.game_id, title = it.game_title)
            }
        return localGames.ifEmpty {
            remoteDataSource.fetchAllGames().onEach { game ->
                localDataSource.insertGame(game)
            }.map { it.mapToDomain() }
        }
    }

    override suspend fun searchGame(query: String) =
        remoteDataSource.searchGame(query).map { it.mapToDomain() }

    override suspend fun createGame(token: String, info: CreateGameInfo) {
        remoteDataSource.createGame(token, info)
    }
}