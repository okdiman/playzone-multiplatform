import model.AuthResponse

interface AuthRepository {
    suspend fun login(login: String, password: String): AuthResponse
}