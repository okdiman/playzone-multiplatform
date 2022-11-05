package di

import GamesRepository
import data.ktor.KtorGamesDataSource
import data.repo.GamesRepositoryImpl
import data.sqldelight.SqlDelightGamesDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val gamesModule = DI.Module("gamesModule") {
    bind<GamesRepository>() with provider { GamesRepositoryImpl(instance(), instance()) }
    bind<KtorGamesDataSource>() with provider { KtorGamesDataSource(instance()) }
    bind<SqlDelightGamesDataSource>() with provider { SqlDelightGamesDataSource() }
}