import model.AuthResponse

interface AuthRepository {
    suspend fun login(login: String, password: String): AuthResponse
    fun isUserLoggedIn(): Boolean
    fun fetchToken(): String
}