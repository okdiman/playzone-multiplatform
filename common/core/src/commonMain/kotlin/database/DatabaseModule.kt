package database

import com.okunev_dmitrii.playzone_mobile.Database
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

internal val databaseModule = DI.Module("databaseModule") {
    bindSingleton { DbDriverFactory(instance()) }
    bindSingleton {
        val driverFactory = instance<DbDriverFactory>()
        val driver = driverFactory.createDriver(Database.Schema, "playzone")
        Database(driver)
    }
}