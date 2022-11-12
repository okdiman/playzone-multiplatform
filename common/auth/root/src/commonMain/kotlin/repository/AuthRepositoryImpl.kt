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
        val response = remoteDataSource.performLogin(KtorAuthRequest(login, password)).mapToDomain()
        cacheDataSource.saveToken(response.token)
        return response
    }

    override fun isUserLoggedIn(): Boolean {
        return cacheDataSource.fetchToken().isNotBlank()
    }
}