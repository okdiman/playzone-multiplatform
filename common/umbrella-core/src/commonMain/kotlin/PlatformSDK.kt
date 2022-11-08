import di.Inject
import di.authModule
import di.gamesModule
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.direct
import platform.PlatformConfiguration

object PlatformSDK {
    fun init(configuration: PlatformConfiguration) {
        val umbrellaModule = DI.Module("umbrella") {
            bindSingleton { configuration }
        }

        Inject.createDependencies(
            DI {
                importAll(coreModule, gamesModule, authModule, umbrellaModule)
            }.direct
        )
    }
}