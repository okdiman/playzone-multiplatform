package settings

import com.russhwolf.settings.Settings
import org.kodein.di.DI
import org.kodein.di.bindSingleton

internal val settingsModule = DI.Module("settingsModule") {
    bindSingleton { Settings() }
}