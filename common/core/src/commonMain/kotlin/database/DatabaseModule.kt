package database

import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

internal val databaseModule = DI.Module("databaseModule") {
//    bindSingleton { DbDriverFactory(instance()) }
}