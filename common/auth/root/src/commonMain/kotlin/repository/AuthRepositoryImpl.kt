package repository

import AuthRepository
import ktor.KtorAuthRequest
import ktor.KtorRemoteDataSource
import ktor.mapToDomain
import model.AuthResponse

class AuthRepositoryImpl(
    private val remoteDataSource: KtorRemoteDataSource
) : AuthRepository {
    override suspend fun login(login: String, password: String): AuthResponse {
        return remoteDataSource.performLogin(KtorAuthRequest(login, password)).mapToDomain()
    }
}