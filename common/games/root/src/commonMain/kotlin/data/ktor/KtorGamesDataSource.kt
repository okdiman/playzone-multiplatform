package data.ktor

import KtorSearchGameRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import models.CreateGameInfo

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

    suspend fun createGame(token: String, info: CreateGameInfo) {
        return httpClient.post {
            header("Bearer-Authorization", "bf8487ae-7d47-11ec-90d6-0242ac120003")
            url {
                path("games/create")
                setBody(info)
            }
        }.body()
    }
}