package di

import AuthRepository
import ktor.KtorRemoteDataSource
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance
import repository.AuthRepositoryImpl

val authModule = DI.Module("authModule") {
    bindProvider<AuthRepository> { AuthRepositoryImpl(instance()) }
    bindProvider { KtorRemoteDataSource(instance()) }
}