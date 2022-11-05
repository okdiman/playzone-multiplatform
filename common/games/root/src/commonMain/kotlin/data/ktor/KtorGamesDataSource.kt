package data.ktor

import KtorSearchGameRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path

class KtorGamesDataSource(private val httpClient: HttpClient) {
    suspend fun fetchAllGames(): List<KtorSearchGame> {
        /**
         * post - отвечает за выбор метода запроса
         * .body() - вызывается для того, чтобы дефолтный url заменился/модернизировался
         */
        return httpClient.post {
            url {
                path("games/search")
                setBody(KtorSearchGameRequest(searchQuery = ""))
            }
        }.body()
    }

    suspend fun searchGame(query: String): List<KtorSearchGame> {
        return httpClient.post {
            url {
                path("games/search")
                setBody(KtorSearchGameRequest(searchQuery = query))
            }
        }.body()
    }
}