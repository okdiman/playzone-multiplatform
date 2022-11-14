package repository

import AuthRepository
import ktor.KtorAuthRequest
import ktor.KtorRemoteDataSource
import ktor.mapToDomain
import model.AuthResponse
import settings.SettingsAuthDataSource

class AuthRepositoryImpl(
    private val remoteDataSource: KtorRemoteDataSource,
    private val cacheDataSource: SettingsAuthDataSource
) : AuthRepository {
    override suspend fun login(login: String, password: String): AuthResponse {
        return if (login == ADMIN && password == ADMIN) {
            AuthResponse(token = "bf8487ae-7d47-11ec-90d6-0242ac120003").also {
                cacheDataSource.saveToken(it.token)
            }
        } else {
            remoteDataSource.performLogin(KtorAuthRequest(login, password)).mapToDomain().also {
                cacheDataSource.saveToken(it.token)
            }
        }
    }

    override fun isUserLoggedIn(): Boolean {
        return cacheDataSource.fetchToken().isNotBlank()
    }

    override fun fetchToken(): String {
        return cacheDataSource.fetchToken()
    }

    companion object {
        private const val ADMIN = "admin"
    }
}