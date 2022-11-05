package data.repo

import GamesRepository
import data.ktor.KtorGamesDataSource
import data.ktor.mapToGame
import data.sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
    private val remoteDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource
) : GamesRepository {
    override suspend fun fetchAllGames() = remoteDataSource.fetchAllGames().map { it.mapToGame() }

    override suspend fun searchGame(query: String) =
        remoteDataSource.searchGame(query).map { it.mapToGame() }
}