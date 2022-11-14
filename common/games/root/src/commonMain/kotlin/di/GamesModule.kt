package di

import GamesRepository
import data.ktor.KtorGamesDataSource
import data.repo.GamesRepositoryImpl
import data.sqldelight.SqlDelightGamesDataSource
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

val gamesModule = DI.Module("gamesModule") {
    bindProvider<GamesRepository> { GamesRepositoryImpl(instance(), instance()) }
    bindProvider { KtorGamesDataSource(instance()) }
    bindProvider { SqlDelightGamesDataSource(instance()) }
}