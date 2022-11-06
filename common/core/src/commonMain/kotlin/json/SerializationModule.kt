package json

import kotlinx.serialization.json.Json
import org.kodein.di.DI
import org.kodein.di.bindSingleton

internal val serializationModule = DI.Module("serializationModule") {
    bindSingleton {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
}