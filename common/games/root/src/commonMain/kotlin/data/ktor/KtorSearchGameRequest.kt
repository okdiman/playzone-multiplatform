import kotlinx.serialization.Serializable

@Serializable
data class KtorSearchGameRequest(
    val searchQuery: String
)