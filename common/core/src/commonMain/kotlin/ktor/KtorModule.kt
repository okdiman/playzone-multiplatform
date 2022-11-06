package ktor

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.kodein.di.DI
import org.kodein.di.bindSingleton

internal val ktorModule = DI.Module("ktorModule") {
    bindSingleton {
        /**
         * HttpClient'у Ktor необходимо обязательно передавать движок для работы
         */
        HttpClient(HttpEngineFactory().createEngine()) {
            /**
             * install - позволяет настраивать всякие фичи ктор климента, например логирование,
             * таймауты и так далее
             */
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json(Json {
                    isLenient = true
                    prettyPrint = true
                    useAlternativeNames = true
                })
            }
            install(HttpTimeout) {
                connectTimeoutMillis = 15000
                requestTimeoutMillis = 30000
            }
            /**
             * настройка дефолтного Url для наших ktor запросов
             */
            defaultRequest {
                header("Content-Type", "application/json; charset=UTF-8")
                header("Bearer-Authorization", "2bac6ef1-ca6d-42ca-96f3-923c68e88eca")
                url("https://playzone-backend.herokuapp.com/")
            }
        }
    }
}